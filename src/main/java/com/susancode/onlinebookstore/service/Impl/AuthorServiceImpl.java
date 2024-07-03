package com.susancode.onlinebookstore.service.Impl;

import com.susancode.onlinebookstore.dto.request.AuthorDTO;
import com.susancode.onlinebookstore.dto.response.ApiResponse;
import com.susancode.onlinebookstore.repository.AuthorRepository;
import com.susancode.onlinebookstore.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    @Override
    public ApiResponse createAuthor(AuthorDTO authorDTO) {
       if (authorRepository.existsByName(authorDTO.getName())) {
            return new ApiResponse(false, "Author with name " + authorDTO.getName() + " already exists");
        }
        return null;
    }
}
