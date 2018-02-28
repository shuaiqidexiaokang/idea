package com.lzk.filter;

import org.springframework.http.HttpRequest;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by lzk on 2018/2/11 18:55
 * Description:
 */
@WebFilter(urlPatterns="/*",filterName = "EncodingFilter")
public class EncodingFilter implements Filter{
    private String encoding =null;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.encoding = filterConfig.getInitParameter("encoding");

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        if (encoding !=null &&!encoding.equals("")){
            System.out.println(encoding);
            request.setCharacterEncoding(encoding);
            response.setCharacterEncoding(encoding);
        }
        filterChain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
