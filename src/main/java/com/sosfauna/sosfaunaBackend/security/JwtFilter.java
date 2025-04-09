package com.sosfauna.sosfaunaBackend.security;

import org.springframework.context.annotation.Configuration;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;
import javax.crypto.SecretKey;
import java.io.IOException;
import java.util.Collections;


public class JwtFilter extends OncePerRequestFilter {

    private static final String SECRET = "your-256-bit-secret-your-256-bit-secret-your-256-bit-secret";
    private final SecretKey SECRET_KEY = Keys.hmacShaKeyFor(SECRET.getBytes());

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String header = request.getHeader("Authorization");


        String token = header; //.substring(7);

        try {

            Claims claims = Jwts.parser()
                    .verifyWith(SECRET_KEY)
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();

            String username = claims.getSubject();

            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(username, null, Collections.emptyList());

            authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

            SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        } catch (ExpiredJwtException e) {
            System.out.println("Token expirado!");
        } catch (UnsupportedJwtException e) {
            System.out.println("Formato de token não suportado!");
        } catch (MalformedJwtException e) {
            System.out.println("Token malformado!");
        } catch (SignatureException e) {
            System.out.println("Assinatura inválida!");
        } catch (Exception e) {
            System.out.println("Erro desconhecido: " + e.getMessage());
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        filterChain.doFilter(request, response);
    }
}















//
//@Component
//public class JwtFilter extends OncePerRequestFilter{
//    private static final String SECRET ="meu-super-segredo-jwt-256-bits-que-e-bem-grande-e-seguro";
//    private final SecretKey SECRET_KEY = Keys.hmacShaKeyFor(SECRET.getBytes());
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//            throws ServletException, IOException {
//
//        System.out.println(">>>>> doFilter sendo usado!");
//        String path = request.getRequestURI();
//        String method = request.getMethod();
//
//        // Ignora filtros para endpoints públicos
//        if (
//                path.startsWith("/auth") ||
//                        (path.equals("/denuncia/todas") && method.equals("GET"))
//        ) {
//            filterChain.doFilter(request, response);
//            return;
//        }
//
//        String header = request.getHeader("Authorization");
//
//        if (header == null || !header.startsWith("Bearer ")) {
//            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//            return;
//        }
//
//        String token = header.substring(7);
//
//        try {
//
//            Claims claims = Jwts.parser()
//                    .verifyWith(SECRET_KEY)
//                    .build()
//                    .parseSignedClaims(token)
//                    .getPayload();
//
//            String username = claims.getSubject();
//
//            UsernamePasswordAuthenticationToken authenticationToken =
//                    new UsernamePasswordAuthenticationToken(username, null, Collections.emptyList());
//
//            authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//
//            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
//            System.out.println("Usuário autenticado: " + username);
//
//
//        } catch (JwtException e) {
//        System.out.println("Erro no JWT: " + e.getMessage());
//        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//        return;
//    }
//
//        filterChain.doFilter(request, response);
//    }
//
//}
