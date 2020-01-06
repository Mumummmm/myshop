package com.spike.my.shop.web.admin.web.interceptor;

import com.spike.my.shop.commons.constants.ConstantUtils;
import com.spike.my.shop.domain.TbUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PermissionInterceptor implements HandlerInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(PermissionInterceptor.class);

    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        return true;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        String viewName = modelAndView.getViewName();
        if (viewName != null && viewName.endsWith("login")) {
            logger.info("viewName : {}", viewName);
            TbUser tbUser = (TbUser) httpServletRequest.getSession().getAttribute(ConstantUtils.SESSION_USER);
            if (tbUser != null) {
                httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/main");
            }
        }

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
