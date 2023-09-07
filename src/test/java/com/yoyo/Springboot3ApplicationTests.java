package com.yoyo;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

//@SpringBootTest
class Springboot3ApplicationTests {

    @Test
    public void testGetJwt(){
        Map<String, Object> claims=new HashMap<>();
        claims.put("id",1);
        claims.put("name","tom");
        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, "yoyo")//设置签名算法
                .setClaims(claims) //自定义内容
                .setExpiration(new Date(System.currentTimeMillis()))//设置有效期为1小时)
                .compact();
        System.out.println(jwt);
    }

    @Test
    public void testParseJwt(){
        Claims yoyo = Jwts.parser()
                .setSigningKey("yoyo")
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoidG9tIiwiaWQiOjEsImV4cCI6MTY5MzgzNDMwM30.q57FiIf8uVsEqQvtUe90pAVxB8SM4rmFJYn-pJA-lSI")
                .getBody();
        System.out.println(yoyo);


    }

}
