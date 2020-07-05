package com.zrh.image.controller;

import com.zrh.image.domain.User;
import com.zrh.image.entity.vo.LoginVO;
import com.zrh.image.service.impl.UserServiceImpl;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class LoginController {
    Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    private final UserServiceImpl userService;

    @PostMapping("/auth/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody LoginVO login) {
        System.out.println("key111:" + key);
        List<User> list = userService.list()
                .stream()
                .filter(u -> u.getPhone().equals(login.getUserName()) && u.getPassword().equals(login.getPassword()))
                .collect(Collectors.toList());
        Map<String, Object> result = new HashMap<>();
        result.put("success", 0);
        result.put("data", "用户名或密码错误");
        if (list.size() > 0) {
            User user = list.get(0);
            Map<String, Object> m = new HashMap<>();
            m.put("id", user.getId());
            m.put("userName", user.getPhone());
            String jws = Jwts.builder()
                    .setSubject(m.toString())
                    .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60))
                    .signWith(key)
                    .compact();
            result.put("success", 1);
            result.put("data", jws);
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("/auth/check")
    public String check(HttpServletRequest request) {
        Jws<Claims> claimsJws = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(request.getHeader("authorization"));
        return claimsJws.getBody().getSubject();
    }
}
