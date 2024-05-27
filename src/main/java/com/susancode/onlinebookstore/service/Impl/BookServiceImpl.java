package com.susancode.onlinebookstore.service.Impl;

import com.susancode.onlinebookstore.dto.request.BookDTO;
import com.susancode.onlinebookstore.dto.response.ApiResponse;
import com.susancode.onlinebookstore.enums.BookStatus;
import com.susancode.onlinebookstore.exception.BadRequestException;
import com.susancode.onlinebookstore.exception.NotFoundException;
import com.susancode.onlinebookstore.model.Book;
import com.susancode.onlinebookstore.repository.BookRepository;
import com.susancode.onlinebookstore.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 *This is an implementation class for BookService interface.
 *it provides methods for adding, retrieving, updating, and deleting books.
 */


@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public ApiResponse addBook(BookDTO bookDTO) {
        if (bookRepository.existsByTitle(bookDTO.getTitle())) {
            throw new BadRequestException("Book with title already exists");
        }

        Book book = convertToEntity(bookDTO);
        bookRepository.save(book);

        return new ApiResponse<>(true,"Book added successfully", book);
    }

    public Book getBookByUuid(UUID bookId) {
        return bookRepository.findFirstByUuid(bookId)
                .orElseThrow(() -> new NotFoundException("Book not found"));
    }

    @Override
    public List<Book> getAllAvailableBooks() {
        return bookRepository.findByStatus(BookStatus.AVAILABLE);
    }

    @Override
    public ApiResponse<Book>updateBook(UUID bookId, BookDTO bookDTO) {
        Book book = bookRepository.findFirstByUuid(bookId)
                .orElseThrow(() -> new NotFoundException("Book not found"));

        book.setTitle(bookDTO.getTitle());
        book.setAuthor(bookDTO.getAuthor());
        book.setDescription(bookDTO.getDescription());
        book.setPrice(bookDTO.getPrice());
        book.setQuantity(bookDTO.getQuantity());
        book.setCategory(bookDTO.getCategory());
        book.setAvailable(bookDTO.isAvailable());
        Book updatedBook = bookRepository.save(book);

        return new ApiResponse<>(true, "Book updated successfully", updatedBook);
    }

    @Override
    public ApiResponse deleteBook(UUID bookId) {
        Book book = bookRepository.findFirstByUuid(bookId)
                .orElseThrow(() -> new NotFoundException("Book not found"));

        bookRepository.delete(book);

        return new ApiResponse(true, "Book deleted successfully");
    }

    private Book convertToEntity(BookDTO bookDTO) {
        Book book = new Book();
        book.setTitle(bookDTO.getTitle());
        book.setAuthor(bookDTO.getAuthor());
        book.setDescription(bookDTO.getDescription());
        book.setPrice(bookDTO.getPrice());
        book.setQuantity(bookDTO.getQuantity());
        book.setCategory(bookDTO.getCategory());
        book.setAvailable(bookDTO.isAvailable());
        book.setUuid(UUID.randomUUID());
        return book;
    }

}
