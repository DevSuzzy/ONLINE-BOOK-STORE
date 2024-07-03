package com.susancode.onlinebookstore.service.Impl;

import com.susancode.onlinebookstore.dto.request.AuthorDTO;
import com.susancode.onlinebookstore.dto.response.ApiResponse;
import com.susancode.onlinebookstore.exception.NotFoundException;
import com.susancode.onlinebookstore.model.Author;
import com.susancode.onlinebookstore.repository.AuthorRepository;
import com.susancode.onlinebookstore.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    @Override
    public ApiResponse createAuthor(AuthorDTO authorDTO) {
       if (authorRepository.existsByName(authorDTO.getName())) {
            return new ApiResponse(false, "Author with name " + authorDTO.getName() + " already exists");
        }
         Author author = convertToEntity(authorDTO);
        authorRepository.save(author);
        return new ApiResponse(true, "Author added successfully", author);
    }

    @Override
    public Author getAuthorByUuid(UUID authorId) {

        return authorRepository.findFirstByUuid(authorId)
                .orElseThrow(() -> new NotFoundException("Author not found"));
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public ApiResponse updateAuthor(UUID authorId, AuthorDTO authorDTO) {
         Author author = authorRepository.findFirstByUuid(authorId)
                .orElseThrow(() -> new NotFoundException("Author not found"));
        author.setName(authorDTO.getName());
        author.setBiography(authorDTO.getBiography());
        author.setNationality(authorDTO.getNationality());
        authorRepository.save(author);
        return new ApiResponse(true, "Author updated successfully", author);
        }

    @Override
    public ApiResponse deleteAuthor(UUID authorId) {
        Author author = authorRepository.findFirstByUuid(authorId)
                .orElseThrow(() -> new NotFoundException("Author not found"));
        authorRepository.delete(author);
        return new ApiResponse(true, "Author deleted successfully", author);
    }


    private Author convertToEntity(AuthorDTO authorDTO) {
        Author author = new Author();
        author.setName(authorDTO.getName());
        author.setBiography(authorDTO.getBiography());
        author.setNationality(authorDTO.getNationality());
        return author;
    }
}
