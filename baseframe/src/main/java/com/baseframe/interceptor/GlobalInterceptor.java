package com.baseframe.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.baseframe.util.SystemConfigBean;

public class GlobalInterceptor extends HandlerInterceptorAdapter{

    @Resource
    private SystemConfigBean systemConfigBean;
    
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
            request.setAttribute("ctx", request.getContextPath());
            request.setAttribute("title", systemConfigBean.getTitle());
            return true;
        }
}
