package com.susancode.onlinebookstore.controller;

import com.susancode.onlinebookstore.dto.request.BookDTO;
import com.susancode.onlinebookstore.dto.response.ApiResponse;
import com.susancode.onlinebookstore.model.Book;
import com.susancode.onlinebookstore.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
public class BooksController {
    private final BookService bookService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse addBook(@RequestBody @Valid BookDTO bookDTO) {
        return bookService.addBook(bookDTO);
    }

    @GetMapping("/{uuid}")
    public Book getBookByUuid(@PathVariable("uuid") UUID bookId) {
        return bookService.getBookByUuid(bookId);
    }
    @GetMapping
    public List<Book> getAllAvailableBooks() {
        return bookService.getAllAvailableBooks();

    }

    @PutMapping("/{uuid}")
    public ApiResponse  updateBook(@PathVariable("uuid") UUID bookId, @RequestBody @Valid BookDTO bookDTO) {
        return bookService.updateBook(bookId, bookDTO);
    }

    @DeleteMapping("/{uuid}")
    public ApiResponse  deleteBook(@PathVariable("uuid") UUID bookId) {
        return  bookService.deleteBook(bookId);

    }
}