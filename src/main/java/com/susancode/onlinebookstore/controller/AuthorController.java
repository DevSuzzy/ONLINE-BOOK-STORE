package com.susancode.onlinebookstore.controller;

import com.susancode.onlinebookstore.dto.request.AuthorDTO;
import com.susancode.onlinebookstore.dto.response.ApiResponse;
import com.susancode.onlinebookstore.model.Author;
import com.susancode.onlinebookstore.service.AuthorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping ("/api/v1/authors")
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService authorService;

    @PostMapping
    public ApiResponse createAuthor(@RequestBody @Valid AuthorDTO authorDTO) {
        return authorService.createAuthor(authorDTO);
    }
    @GetMapping("/{uuid}")
    public Author getAuthorByUuid(@PathVariable("uuid") UUID authorId) {
        return authorService.getAuthorByUuid(authorId);
    }
    @GetMapping
    public List<Author> getAllAuthors() {
        return authorService.getAllAuthors();
    }
    @PutMapping("/{uuid}")
    public ApiResponse updateAuthor(@PathVariable("uuid") UUID authorId, @RequestBody @Valid AuthorDTO authorDTO) {
        return authorService.updateAuthor(authorId, authorDTO);
    }
    @DeleteMapping("/{uuid}")
    public ApiResponse deleteAuthor(@PathVariable("uuid") UUID authorId) {
        return authorService.deleteAuthor(authorId);
    }
}
