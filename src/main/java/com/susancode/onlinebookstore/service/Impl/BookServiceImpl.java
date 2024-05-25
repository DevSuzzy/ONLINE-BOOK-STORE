package com.susancode.onlinebookstore.service.Impl;

import com.susancode.onlinebookstore.dto.request.BookDTO;
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

    // Method to add a new book
    public BasicResponse addBook(BookDTO bookDTO) {
        // Check if a book with the same title already exists
        if (bookRepository.existsByTitle(bookDTO.getTitle())) {
            throw new BadRequestException("Book with title already exists");
        }

        // Convert BookDTO to Books entity and save it to the database
        Books book = convertToEntity(bookDTO);
        bookRepository.save(book);

        // Return a success response
        return new BasicResponse("Book added successfully");
    }

    // Method to retrieve a book by its UUID
    public Books getBookByUuid(UUID bookId) {
        // Find and return the book by its UUID, or throw a NotFoundException if not found
        return bookRepository.findFirstByUuid(bookId)
                .orElseThrow(() -> new NotFoundException("Book not found"));
    }

    // Method to retrieve all available books
    @Override
    public List<Books> getAllAvailableBooks() {
        // Retrieve and return all books with status AVAILABLE
        return bookRepository.findByStatus(BookStatus.AVAILABLE);
    }

    // Method to update an existing book
    @Override
    @Transactional
    public BasicResponse updateBook(UUID bookId, BookDTO bookDTO) {
        // Find the book by its UUID
        Books book = bookRepository.findFirstByUuid(bookId)
                .orElseThrow(() -> new NotFoundException("Book not found"));

        // Update the book details with the information from the BookDTO
        book.setTitle(bookDTO.getTitle());
        book.setAuthor(bookDTO.getAuthor());
        book.setDescription(bookDTO.getDescription());
        book.setPrice(bookDTO.getPrice());
        book.setQuantity(bookDTO.getQuantity());
        book.setCategory(bookDTO.getCategory());
        book.setAvailable(bookDTO.isAvailable());

        // Return a success response
        return new BasicResponse("Book updated successfully");
    }

    // Method to delete a book by its UUID
    @Override
    public BasicResponse deleteBook(UUID bookId) {
        // Find the book by its UUID
        Books book = bookRepository.findFirstByUuid(bookId)
                .orElseThrow(() -> new NotFoundException("Book not found"));

        // Delete the book from the database
        bookRepository.delete(book);

        // Return a success response
        return new BasicResponse("Book deleted successfully");
    }

    // Helper method to convert BookDTO to Books entity
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
