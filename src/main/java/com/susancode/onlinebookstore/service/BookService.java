package com.susancode.onlinebookstore.service;

import com.susancode.onlinebookstore.dto.request.BookDTO;

import com.susancode.onlinebookstore.dto.response.ApiResponse;
import com.susancode.onlinebookstore.model.Books;

import java.util.List;
import java.util.UUID;

public interface BookService {
    ApiResponse addBook(BookDTO bookDTO);

    Books getBookByUuid(UUID bookId);
    List<Books> getAllAvailableBooks();
    ApiResponse updateBook(UUID bookId, BookDTO bookDTO);

    ApiResponse deleteBook(UUID bookId);

}
