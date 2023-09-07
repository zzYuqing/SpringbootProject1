package com.yoyo.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter(urlPatterns = "/*")
public class DemoFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init done");
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("拦截执行");
        //放行前的逻辑
        System.out.println("放行前");
        //放行
        System.out.println("放行：允许访问资源");
        chain.doFilter(request,response);

        //放行后的逻辑
        System.out.println("放行后：资源访问后，回到放行后的逻辑");
    }

    @Override
    public void destroy() {
        System.out.println("destroy done");
        Filter.super.destroy();
    }
}
