package com.yoyo.filter;

import com.alibaba.fastjson.JSONObject;
import com.yoyo.pojo.Result;
import com.yoyo.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
//@WebFilter(urlPatterns = "/*")
public class LoginCheckFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req=(HttpServletRequest)  request;
        HttpServletResponse resp=(HttpServletResponse) response;
        //1.获取请求的url
        String url=req.getRequestURI().toString();
        log.info("请求的url：{}",url);

        //2.判断请求url是否包含login，包含则放行
        if(url.contains("login")){
            log.info("登陆操作，放行...");
            chain.doFilter(request,response);
            return;
        }
        //3.获取令牌token
        String jwt =req.getHeader("token");
        //4.判断令牌是否存在，不存在则返回错误结果
        if(!StringUtils.hasLength(jwt)){
            log.info("token空，返回未登录信息");
            Result error=Result.error("NOT_LOGIN");
            //手动转换 对象--json
            String notLogin = JSONObject.toJSONString(error);
            resp.getWriter().write(notLogin);
            return;
        }
        //5.解析token，解析失败则返回错误结果
        try{
            JwtUtils.parseJWT(jwt);
        }catch (Exception e){
            e.printStackTrace();
            log.info("解析token失败，返回未登录信息");
            Result error=Result.error("NOT_LOGIN");
            //手动转换 对象--json
            String notLogin = JSONObject.toJSONString(error);
            resp.getWriter().write(notLogin);
            return;
        }
        //6.放行
        log.info("令牌合法，放行");
        chain.doFilter(request,response);

    }
}
