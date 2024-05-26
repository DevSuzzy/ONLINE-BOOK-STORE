package com.susancode.onlinebookstore.service.Impl;

import com.susancode.onlinebookstore.dto.request.BookDTO;
import com.susancode.onlinebookstore.dto.response.ApiResponse;
import com.susancode.onlinebookstore.dto.response.BasicResponse;
import com.susancode.onlinebookstore.enums.BookStatus;
import com.susancode.onlinebookstore.exception.BadRequestException;
import com.susancode.onlinebookstore.exception.NotFoundException;
import com.susancode.onlinebookstore.model.Books;
import com.susancode.onlinebookstore.repository.BookRepository;
import com.susancode.onlinebookstore.service.BookService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public ApiResponse addBook(BookDTO bookDTO) {
        if (bookRepository.existsByTitle(bookDTO.getTitle())) {
            throw new BadRequestException("Book with title already exists");
        }

        Books book = convertToEntity(bookDTO);
        bookRepository.save(book);

        return new ApiResponse<>(true,"Book added successfully", book);
    }

    public Books getBookByUuid(UUID bookId) {
        return bookRepository.findFirstByUuid(bookId)
                .orElseThrow(() -> new NotFoundException("Book not found"));
    }

    @Override
    public List<Books> getAllAvailableBooks() {
        return bookRepository.findByStatus(BookStatus.AVAILABLE);
    }

    @Override
    public ApiResponse<Books>updateBook(UUID bookId, BookDTO bookDTO) {
        Books book = bookRepository.findFirstByUuid(bookId)
                .orElseThrow(() -> new NotFoundException("Book not found"));

        book.setTitle(bookDTO.getTitle());
        book.setAuthor(bookDTO.getAuthor());
        book.setDescription(bookDTO.getDescription());
        book.setPrice(bookDTO.getPrice());
        book.setQuantity(bookDTO.getQuantity());
        book.setCategory(bookDTO.getCategory());
        book.setAvailable(bookDTO.isAvailable());
        Books updatedBook = bookRepository.save(book);

        return new ApiResponse<>(true, "Book updated successfully", updatedBook);
    }

    @Override
    public ApiResponse deleteBook(UUID bookId) {
        Books book = bookRepository.findFirstByUuid(bookId)
                .orElseThrow(() -> new NotFoundException("Book not found"));

        bookRepository.delete(book);

        return new ApiResponse(true, "Book deleted successfully");
    }

    private Books convertToEntity(BookDTO bookDTO) {
        Books book = new Books();
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
