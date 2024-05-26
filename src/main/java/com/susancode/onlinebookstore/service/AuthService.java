package com.susancode.onlinebookstore.service;

import com.susancode.onlinebookstore.dto.request.LoginDTO;
import com.susancode.onlinebookstore.dto.response.ApiResponse;

public interface AuthService {
    ApiResponse login(LoginDTO dto);

}
