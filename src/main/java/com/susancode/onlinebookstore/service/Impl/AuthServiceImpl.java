package com.susancode.onlinebookstore.service.Impl;

import com.susancode.onlinebookstore.config.TokenProvider;
import com.susancode.onlinebookstore.dto.request.LoginDTO;
import com.susancode.onlinebookstore.dto.response.ApiResponse;
import com.susancode.onlinebookstore.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Map;


/**
 * This an Implementation class for AuthService interface.
 * it handles user authentication logic, such as generating JWT tokens upon successful login.
 */


@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final TokenProvider tokenProvider;

    private final AuthenticationManager authenticationManager;

    @Override
    public ApiResponse login(LoginDTO dto) {

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword());
        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = tokenProvider.createToken(authentication);
        return new ApiResponse(true, "success", Map.of("token", token));
    }
}
