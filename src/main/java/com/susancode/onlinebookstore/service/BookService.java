package com.susancode.onlinebookstore.service;

import com.susancode.onlinebookstore.dto.request.BookDTO;

import com.susancode.onlinebookstore.dto.response.ApiResponse;
import com.susancode.onlinebookstore.model.Book;

import java.util.List;
import java.util.UUID;

public interface BookService {
    ApiResponse addBook(BookDTO bookDTO);

    Book getBookByUuid(UUID bookId);
    List<Book> getAllAvailableBooks();
    ApiResponse updateBook(UUID bookId, BookDTO bookDTO);

    ApiResponse deleteBook(UUID bookId);

}
