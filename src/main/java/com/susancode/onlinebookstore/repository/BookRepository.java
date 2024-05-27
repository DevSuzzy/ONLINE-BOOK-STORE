package com.susancode.onlinebookstore.repository;

import com.susancode.onlinebookstore.enums.BookStatus;
import com.susancode.onlinebookstore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 *This is a Repository interface for managing Book entities in the database.
 *it extends JpaRepository for basic CRUD operations.
 */

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {


    boolean existsByTitle(String title);

    List<Book> findByStatus(BookStatus bookStatus);

    Optional<Book> findFirstByUuid(UUID bookId);
}