package com.zrh.image.controller;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Key;
import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {
    Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    @GetMapping("/login")
    public String login() {

        Map<String, Object> map = new HashMap<>();
        map.put("name", "ruihua");
        map.put("age", 29);
        String jws = Jwts.builder().setSubject(map.toString()).signWith(key).compact();
        return jws;
    }

    @GetMapping("/check")
    public String check(String token) {
        Jws<Claims> claimsJws = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
        return claimsJws.getBody().getSubject();
    }
}
