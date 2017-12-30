package com.lzk.interceptors;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by lzk on 2017/12/30 13:53
 * Description:自定义拦截器
 */
public class FirstInterceptor implements HandlerInterceptor {
    /**
     * 该方法在目标方法之前被调用.
     * 若返回值为 true, 则继续调用后续的拦截器和目标方法.
     * 若返回值为 false, 则不会再调用后续的拦截器和目标方法.
     *
     * 可以考虑做权限. 日志, 事务等.
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("[FirstInterceptor] preHandle");
        return true;
    }

    /**
     * 调用目标方法之后, 但渲染视图之前.
     * 可以对请求域中的属性或视图做出修改.
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("[FirstInterceptor] postHandle");
    }

    /**
     * 渲染视图之后被调用. 释放资源
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param e
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("[FirstInterceptor] afterCompletion");
    }
}
