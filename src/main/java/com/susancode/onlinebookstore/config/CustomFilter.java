package com.susancode.onlinebookstore.config;

import jakarta.servlet.*;
import org.springframework.web.filter.GenericFilterBean;

import java.io.IOException;

public class CustomFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws  ServletException, IOException {
        filterChain.doFilter(servletRequest,servletResponse);
    }
}

