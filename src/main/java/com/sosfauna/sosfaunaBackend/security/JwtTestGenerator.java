package com.sosfauna.sosfaunaBackend.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Date;

public class JwtTestGenerator {
    public static void main(String[] args) {
        String secret = "your-256-bit-secret-your-256-bit-secret-your-256-bit-secret";
        SecretKey key = Keys.hmacShaKeyFor(secret.getBytes());

        String token = Jwts.builder()
                .subject("ibama@org.com")
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24)) // 24h
                .signWith(Keys.hmacShaKeyFor(secret.getBytes()), Jwts.SIG.HS256)
                .compact();


        System.out.println("Token JWT gerado: " + token);
    }
}
