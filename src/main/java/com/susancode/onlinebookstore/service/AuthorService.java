package com.susancode.onlinebookstore.service;

import com.susancode.onlinebookstore.dto.request.AuthorDTO;
import com.susancode.onlinebookstore.dto.response.ApiResponse;

public interface AuthorService {
   ApiResponse createAuthor(AuthorDTO authorDTO);
}
