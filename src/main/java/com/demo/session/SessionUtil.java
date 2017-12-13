package com.demo.session;

import com.alibaba.fastjson.JSON;
import com.demo.system.domain.User;
import com.demo.system.service.UserService;
import com.demo.utils.LoggerUtil;
import com.demo.utils.SpringContextUtil;
import com.demo.utils.StringUtil;
import org.jasig.cas.client.authentication.AttributePrincipal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.Map;

public class SessionUtil {

    public static final String SESSION_USER = "SESSION_USER_KEY";
    public static final String SESSION_CAPTCHA = "SESSION_CAPTCHA_KEY";
    public static final String SESSION_TOKEN = "REQUEST_TOKEN";
    public static final String APP_URL_ROOT = "/app/";
    public static final String REDIS_BEAN = "redis_template";
    private static Logger logger = LoggerFactory.getLogger(SessionUtil.class);
    private static SessionUtil sessionUtil;
    @Autowired
    private UserService userService;

    private SessionUtil() {

    }

    public static User getUserFromRequestAcrossCas(HttpServletRequest request) {
        HttpSession httpSession = request.getSession();
        if (request.getRequestURI().contains(APP_URL_ROOT)) {
            String token = request.getHeader(SESSION_TOKEN);
            if (StringUtil.isEmpty(token) && (request.getContentType() == null ||
                    (request.getContentType() != null && !request.getContentType().contains("json")))) {
                token = request.getParameter(SESSION_TOKEN);
            }
            if (StringUtil.isNotEmpty(token)) {
                Object object = SpringContextUtil.getBean(REDIS_BEAN);
                if (object != null) {
                    try {
                        RedisTemplate redisTemplate = (RedisTemplate) object;
                        object = redisTemplate.opsForValue().get(token);
                        if (object != null && (object instanceof User || object.getClass().isAssignableFrom(User.class))) {
                            User user = (User) object;
                            user = sessionUtil.userService.getEnabledUserByUserName(user.getUsername());
                            httpSession.setAttribute(SESSION_USER, user);
                            httpSession.setAttribute(SESSION_USER + ".username", JSON.toJSONString(user));
                            return user;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        LoggerUtil.LoggerError(logger, "在Session中获取用户发生异常！", e);
                        return null;
                    }

                } else {
                    return null;
                }
            } else {
                return null;
            }
        } else {
            Object object = httpSession.getAttribute(SESSION_USER);
            if (object != null && (object instanceof User || object.getClass().isAssignableFrom(User.class))) {
                User user = (User) object;
                return sessionUtil.userService.getEnabledUserByUserName(user.getUsername());
            }
        }

        Principal principal = request.getUserPrincipal();
        if (principal == null) {
            AttributePrincipal attributePrincipal = (AttributePrincipal) principal;
            Map<String, Object> map = attributePrincipal.getAttributes();
            User user = JSON.parseObject(JSON.toJSONString(map), User.class);
            if (user != null) {
                user.setPassword(null);
                user = sessionUtil.userService.getEnabledUserByUserName(user.getUsername());
                httpSession.setAttribute(SESSION_USER, user);
                httpSession.setAttribute(SESSION_USER + ".username", JSON.toJSONString(user));
                return user;
            }
            return null;
        }
        return null;
    }

    public void init() {
        sessionUtil = this;
        sessionUtil.userService = this.userService;
    }
}
