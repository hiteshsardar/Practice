package org.com.practice.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JWTService {
    public String generateToken(String email) {
        Map<String, Object> claims = new HashMap<>();
        return Jwts.builder()
                .claims()
                .add(claims)
                .subject(email)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 60 * 60 * 15))
                .and()
                .signWith(getKey())
                .compact();
    }

    private Key getKey() {
        try {

        KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacSHA256");
        SecretKey secretKey = keyGenerator.generateKey();
        byte [] secret = secretKey.getEncoded();
        return Keys.hmacShaKeyFor(secret);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
