package com.qlu.restfulcrud.component;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author jiajinshuo
 * @create 2020-02-08 19:06
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {
    //目标方法执行之前
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user = request.getSession().getAttribute("loginUser");
        if(user==null){
            request.setAttribute("msg","没有权限，请先登录");//request域
            //未登录，返回登录页面
            request.getRequestDispatcher("/").forward(request,response);
            return false;
        }else {
            //已登录，放行请求
            return true;
        }
    }

    public  void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    }

    public  void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
    }


}
