package com.susancode.onlinebookstore.service;

import com.susancode.onlinebookstore.dto.request.AuthorDTO;
import com.susancode.onlinebookstore.dto.response.ApiResponse;
import com.susancode.onlinebookstore.model.Author;

import java.util.List;
import java.util.UUID;

public interface AuthorService {
   ApiResponse createAuthor(AuthorDTO authorDTO);
   Author getAuthorByUuid(UUID authorId);

   List<Author> getAllAuthors();

   ApiResponse updateAuthor(UUID authorId, AuthorDTO authorDTO);

   ApiResponse deleteAuthor(UUID authorId);
}
