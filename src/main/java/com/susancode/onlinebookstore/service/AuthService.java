package com.susancode.onlinebookstore.service;

import com.susancode.onlinebookstore.dto.request.LoginDTO;
import com.susancode.onlinebookstore.dto.response.ApiResponse;
/**
 * This a Service interface for handling authentication-related operations.
 * it defines a method for user login, which returns an ApiResponse.
 */


public interface AuthService {
    ApiResponse login(LoginDTO dto);

}
