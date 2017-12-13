package com.demo.system.controller;

import com.demo.base.BaseController;
import com.demo.base.SystemConstant;
import com.demo.session.SessionUtil;
import com.demo.system.dao.UserMapper;
import com.demo.system.domain.User;
import com.demo.system.parameter.UserParam;
import com.demo.utils.LoggerUtil;
import com.demo.utils.ValidationUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping({"/", "/web"})
public class LoginController extends BaseController {

    private final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserMapper userMapper;

    @RequestMapping({"/", ""})
    public void homePage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            logger.info("登录页面加载中……");
            response.setHeader("Pasgma", "no-cache");
            response.setDateHeader("Expires", 0);
            response.addHeader("Cache-Control", "no-cache");
            response.addHeader("Cache-Control", "no-store");
            response.addHeader("Cache-control", "must-revalidate");
            response.sendRedirect(request.getContextPath() + SystemConstant.DEFAULT_LOGOUT_URL);
            logger.info("重定向至登陆页面……");
        } catch (Exception e) {
            e.printStackTrace();
            LoggerUtil.LoggerError(logger, "重定向页面发生异常！", e);
        }
    }

    @RequestMapping("/showLogin")
    public String showLogin(HttpServletRequest request, HttpServletResponse response, Model model) {
        return AccessPrefix.SYSTEM + "/login";
    }

    @RequestMapping("/doLogin")
    @ResponseBody
    public String doLogin(@ModelAttribute UserParam userParam, BindingResult bindingResult,
                          HttpServletRequest request, HttpServletResponse response, Model model) {
        try {
            // 后台数据校验
            ValidationUtil.isValid(bindingResult, userParam, UserParam.Login.class);
            if (bindingResult.hasErrors()) {
                return getJsonResult(Status.DATA_ERROR.getCode(), ValidationUtil.getFieldErrorString(bindingResult));
            }
            // 校验用户是否存在
            User user = new User();
            user.setUsername(userParam.getUsername());
            List<User> users = userMapper.queryByObject(user);
            if (CollectionUtils.isEmpty(users)) {
                bindingResult.rejectValue("username", "", "账号不存在！");
                return getJsonResult(Status.DATA_ERROR.getCode(), ValidationUtil.getFieldErrorString(bindingResult));
            }
            // 校验用户是否被禁用或删除
            user = userMapper.getEnabledUserByUserName(userParam.getUsername());
            if (user == null) {
                bindingResult.rejectValue("username", "", "账号已被禁用或已被删除！");
                return getJsonResult(Status.DATA_ERROR.getCode(), ValidationUtil.getFieldErrorString(bindingResult));
            }
            // 校验密码是否正确
            if (!user.getPassword().equals(userParam.getPassword())) {
                bindingResult.rejectValue("password", "", "账号或密码输入错误！");
                return getJsonResult(Status.DATA_ERROR.getCode(), ValidationUtil.getFieldErrorString(bindingResult));
            }

            // 登陆成功 设置Session User
            request.getSession().setAttribute(SessionUtil.SESSION_USER, user);
            return getJsonResult(Status.SUCCESS.getCode(), "登陆成功！");
        } catch (Exception e) {
            e.printStackTrace();
            LoggerUtil.LoggerError(logger, "执行登陆发生异常！", e);
            return getJsonResult(Status.EXCEPTION.getCode(), "执行登陆发生异常！");
        }
    }

    @RequestMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        try {
            // 销毁Session
            HttpSession httpSession = request.getSession();
            httpSession.removeAttribute(SessionUtil.SESSION_USER);
            httpSession.invalidate();
            // 重定向至登陆页
            response.sendRedirect(request.getContextPath() + SystemConstant.DEFAULT_LOGOUT_URL);
        } catch (Exception e) {
            e.printStackTrace();
            LoggerUtil.LoggerError(logger, "注销登陆发生异常！", e);
        }
    }
}
