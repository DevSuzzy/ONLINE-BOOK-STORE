package com.susancode.onlinebookstore;

import com.susancode.onlinebookstore.dto.request.BookDTO;
import com.susancode.onlinebookstore.dto.response.ApiResponse;
import com.susancode.onlinebookstore.enums.BookStatus;
import com.susancode.onlinebookstore.exception.BadRequestException;
import com.susancode.onlinebookstore.exception.NotFoundException;
import com.susancode.onlinebookstore.model.Books;
import com.susancode.onlinebookstore.repository.BookRepository;
import com.susancode.onlinebookstore.service.Impl.BookServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@MockitoSettings(strictness = Strictness.LENIENT)
@ActiveProfiles("test")
@SpringBootTest
@ExtendWith({MockitoExtension.class })

public class BookServiceTest {
    @MockBean
    private BookRepository bookRepository;
    @Autowired
    private BookServiceImpl  bookService;


    @Test
    @DisplayName("Add book successfully")
    void addBookSuccessfully() {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setTitle("Test Book");
        bookDTO.setAuthor("Test Author");
        bookDTO.setDescription("Test Description");
        bookDTO.setPrice(100.0);
        bookDTO.setQuantity(10);
        bookDTO.setCategory("Test Category");
        bookDTO.setAvailable(true);
        bookDTO.getStatus();

        when(bookRepository.existsByTitle("Test Book")).thenReturn(false);
        when(bookRepository.save(any())).thenAnswer(invocation -> invocation.getArgument(0));

        ApiResponse<Books> response = bookService.addBook(bookDTO);

        assertNotNull(response);
        assertTrue(response.isRequestSuccessful());
        assertEquals("Book added successfully", response.getResponseMessage());
        assertNotNull(response.getResponseBody());
        verify(bookRepository, times(1)).save(any());
    }

    @Test
    @DisplayName("Add book with existing title should throw BadRequestException")
    void addBookWithExistingTitle_shouldThrowBadRequestException() {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setTitle("Existing Book");

        when(bookRepository.existsByTitle("Existing Book")).thenReturn(true);
        assertThrows(BadRequestException.class, () -> {
            bookService.addBook(bookDTO);
        });
        verify(bookRepository, never()).save(any());
    }

    @Test
    @DisplayName("Get book by UUID")
    void getBookByUuid() {
        UUID bookId = UUID.randomUUID();
        Books book = new Books();
        book.setUuid(bookId);

        when(bookRepository.findFirstByUuid(bookId)).thenReturn(Optional.of(book));
        Books result = bookService.getBookByUuid(bookId);
        assertNotNull(result);
        assertEquals(bookId, result.getUuid());
        verify(bookRepository, times(1)).findFirstByUuid(bookId);
    }

    @Test
    @DisplayName("Get all available books")
    void getAllAvailableBooks() {
        Books book = new Books();
        List<Books> books = Collections.singletonList(book);
        when(bookRepository.findByStatus(any())).thenReturn(books);
        List<Books> result = bookService.getAllAvailableBooks();
        assertNotNull(result);
        assertFalse(result.isEmpty());
        verify(bookRepository, times(1)).findByStatus(any());
    }


        @Test
        @DisplayName("Update existing book successfully")
        void updateExistingBookSuccessfully() {
            // Arrange
            UUID bookId = UUID.randomUUID();
            BookDTO updatedBookDTO = new BookDTO();
            updatedBookDTO.setTitle("Updated Book Title");
            updatedBookDTO.setAuthor("Updated Author");
            updatedBookDTO.setDescription("Updated Description");
            updatedBookDTO.setPrice(150.0);
            updatedBookDTO.setQuantity(5);
            updatedBookDTO.setCategory("Updated Category");
            updatedBookDTO.setAvailable(true);

            Books existingBook = new Books();
            existingBook.setUuid(bookId);
            existingBook.setTitle("Old Book Title");
            existingBook.setAuthor("Old Author");
            existingBook.setDescription("Old Description");
            existingBook.setPrice(100.0);
            existingBook.setQuantity(10);
            existingBook.setCategory("Old Category");
            existingBook.setAvailable(false);

            when(bookRepository.findFirstByUuid(bookId)).thenReturn(Optional.of(existingBook));
            when(bookRepository.save(any())).thenAnswer(invocation -> invocation.getArgument(0));

            ApiResponse<Books> response = bookService.updateBook(bookId, updatedBookDTO);
            assertNotNull(response);
            assertTrue(response.isRequestSuccessful());
            assertEquals("Book updated successfully", response.getResponseMessage());
            verify(bookRepository, times(1)).findFirstByUuid(bookId);
            verify(bookRepository, times(1)).save(any(Books.class));

            assertEquals("Updated Book Title", existingBook.getTitle());
            assertEquals("Updated Author", existingBook.getAuthor());
            assertEquals("Updated Description", existingBook.getDescription());
            assertEquals(150.0, existingBook.getPrice());
            assertEquals(5, existingBook.getQuantity());
            assertEquals("Updated Category", existingBook.getCategory());
            assertTrue(existingBook.isAvailable());
            assertEquals(BookStatus.AVAILABLE, existingBook.getStatus());
        }

    @Test
    @DisplayName("Update non-existing book should throw NotFoundException")
    void updateNonExistingBook_shouldThrowNotFoundException() {
        UUID nonExistingBookId = UUID.randomUUID();
        BookDTO updatedBookDTO = new BookDTO();
        updatedBookDTO.setTitle("Updated Book Title");

        when(bookRepository.findFirstByUuid(nonExistingBookId)).thenReturn(Optional.empty());
        assertThrows(NotFoundException.class, () -> {
            bookService.updateBook(nonExistingBookId, updatedBookDTO);
        });
        verify(bookRepository, times(1)).findFirstByUuid(nonExistingBookId);
        verify(bookRepository, never()).save(any());
    }

    @Test
    @DisplayName("Delete book successfully")
    void deleteBookSuccessfully() {
        UUID bookId = UUID.randomUUID();

        when(bookRepository.findFirstByUuid(bookId)).thenReturn(Optional.of(new Books()));
        ApiResponse<Books> response = bookService.deleteBook(bookId);
        assertNotNull(response);
        assertTrue(response.isRequestSuccessful());
        assertEquals("Book deleted successfully", response.getResponseMessage());
        assertNull(response.getResponseBody());
        verify(bookRepository, times(1)).delete(any());
    }
}

