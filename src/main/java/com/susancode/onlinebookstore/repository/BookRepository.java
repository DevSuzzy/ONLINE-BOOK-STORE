package com.susancode.onlinebookstore.repository;

import com.susancode.onlinebookstore.enums.BookStatus;
import com.susancode.onlinebookstore.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Repository
public interface BookRepository extends JpaRepository<Books, Long> {


    boolean existsByTitle(String title);

    List<Books> findByStatus(BookStatus bookStatus);

    Optional<Books> findFirstByUuid(UUID bookId);
}