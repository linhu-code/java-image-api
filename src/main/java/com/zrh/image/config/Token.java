package com.zrh.image.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.security.Key;


public class Token extends HandlerInterceptorAdapter {
    private final String TOKEN = "authorization";


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String authorization = request.getHeader(TOKEN);
        String servletPath = request.getServletPath();
        System.out.println("check1:" + authorization + "  path:" + servletPath);

        String authBody = check(authorization);
        System.out.println("authBody:" + authBody);
        if (authBody == null) {
            response.setStatus(401);
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=utf-8");
            PrintWriter writer = response.getWriter();
            writer.println("请求登录");
            writer.flush();
            return false;
        }
        return true;
    }

    private String check(String aut) {
        Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        System.out.println("key222:" + key);
        String result = null;
        try {
            System.out.println("auth:" + aut);
            Jws<Claims> claimsJws = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(aut);
            result = claimsJws.getBody().getSubject();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            result = null;
        }
        return result;

    }
}

