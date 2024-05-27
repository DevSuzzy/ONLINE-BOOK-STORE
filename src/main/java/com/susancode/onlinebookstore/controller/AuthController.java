package com.susancode.onlinebookstore.controller;

import com.susancode.onlinebookstore.dto.request.LoginDTO;
import com.susancode.onlinebookstore.dto.response.ApiResponse;
import com.susancode.onlinebookstore.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This is a Controller class that handles authentication-related endpoints.
 * it also defines endpoints for a user authentication, such as login.
 */


@RequestMapping("/api/v1/auth")
@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    @PostMapping("/login")
    public ApiResponse login(@RequestBody @Valid LoginDTO loginDTO) {
        return authService.login(loginDTO);
    }

}


