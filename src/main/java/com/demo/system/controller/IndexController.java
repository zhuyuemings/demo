package com.demo.system.controller;

import com.demo.base.BaseController;
import com.demo.base.SystemConstant;
import com.demo.session.SessionUtil;
import com.demo.system.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/web")
public class IndexController extends BaseController {

    private static final String REDIRECT = "redirect:";

    @RequestMapping("/index")
    public static String showIndex(HttpServletRequest request, HttpServletResponse response) {
        User user = SessionUtil.getUserFromRequestAcrossCas(request);
        if (user == null) {
            return REDIRECT + SystemConstant.DEFAULT_LOGOUT_URL;
        }


        return null;
    }
}
