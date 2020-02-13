package com.tensequare.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import java.text.SimpleDateFormat;

/**
 * 解析 token
 */
public class ParseJwtTest {
    public static void main(String[] args) {
        Claims claims = Jwts.parser()
                .setSigningKey("itcast")
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI2NjYiLCJzdWIiOiLlsI_pqawiLCJpYXQiOjE1NTUxNzk4MDQsImV4cCI6MTU1NTE3OTg2NCwicm9sZSI6ImFkbWluIn0.4AOVCp8-Zj0B3_oBj6ccx99Qe27GDeVkFEpyd6VfT68")
                .getBody();
        System.out.println("用户id：" + claims.getId());
        System.out.println("用户名：" + claims.getSubject());
        System.out.println("登录时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(claims.getIssuedAt()));
        System.out.println("过期时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(claims.getExpiration()));
        System.out.println("用户角色：" + claims.get("role"));
    }
}
