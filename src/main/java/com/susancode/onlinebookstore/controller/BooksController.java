package com.susancode.onlinebookstore.controller;

import com.susancode.onlinebookstore.dto.request.BookDTO;
import com.susancode.onlinebookstore.dto.response.BasicResponse;
import com.susancode.onlinebookstore.model.Books;
import com.susancode.onlinebookstore.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
public class BooksController {
    private final BookService bookService;

    @PostMapping
    public BasicResponse addBook(@RequestBody @Valid BookDTO bookDTO) {
        return bookService.addBook(bookDTO);
    }

    @GetMapping("/{uuid}")
    public Books getBookByUuid(@PathVariable("uuid") UUID bookId) {
        return bookService.getBookByUuid(bookId);
    }
    @GetMapping
    public List<Books> getAllAvailableBooks() {
        return bookService.getAllAvailableBooks();

    }

    @PutMapping("/{uuid}")
    public BasicResponse updateBook(@PathVariable("uuid") UUID bookId, @RequestBody @Valid BookDTO bookDTO) {
        return bookService.updateBook(bookId, bookDTO);
    }

    @DeleteMapping("/{uuid}")
    public BasicResponse deleteBook(@PathVariable("uuid") UUID bookId) {
        return  bookService.deleteBook(bookId);

    }
}