package com.susancode.onlinebookstore.service;

import com.susancode.onlinebookstore.dto.request.BookDTO;

import com.susancode.onlinebookstore.dto.response.BasicResponse;
import com.susancode.onlinebookstore.model.Books;

import java.util.List;
import java.util.UUID;

public interface BookService {
    BasicResponse addBook(BookDTO bookDTO);

    Books getBookByUuid(UUID bookId);
    List<Books> getAllAvailableBooks();
    BasicResponse updateBook(UUID bookId, BookDTO bookDTO);

    BasicResponse deleteBook(UUID bookId);

}
