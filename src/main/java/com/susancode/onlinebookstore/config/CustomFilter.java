package com.susancode.onlinebookstore.config;

import com.susancode.onlinebookstore.exception.UnAuthorized;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.filter.GenericFilterBean;

import java.io.IOException;
@Slf4j
public class CustomFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws  ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String authorizationHeader =request.getHeader("Authorization");
        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            throw new UnAuthorized("Missing or invalid Authorization header");
        }
        String token = authorizationHeader.substring(7);
        System.out.println("Token: "+token);



        //get password from token
        //validate password
        //if password is valid then allow the request to proceed
        //if password is invalid then throw UnAuthorized exception
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken("username", "password");
        //set authentication in security context

        SecurityContextHolder.getContext().setAuthentication(authenticationToken);



        filterChain.doFilter(servletRequest,servletResponse);

    }
    public boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(key).parseClaimsJws(authToken);
            return true;
        } catch (io.jsonwebtoken.security.SecurityException | MalformedJwtException e) {
            log.info("Invalid JWT signature.");
            log.trace("Invalid JWT signature trace: {}", e);
        } catch (ExpiredJwtException e) {
            log.info("Expired JWT token.");
            log.trace("Expired JWT token trace: {}", e);
        } catch (UnsupportedJwtException e) {
            log.info("Unsupported JWT token.");
            log.trace("Unsupported JWT token trace: {}", e);
        } catch (IllegalArgumentException e) {
            log.info("JWT token compact of handler are invalid.");
            log.trace("JWT token compact of handler are invalid trace: {}", e);
        }
        return false;
    }

}





