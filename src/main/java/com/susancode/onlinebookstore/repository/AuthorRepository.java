package com.susancode.onlinebookstore.repository;

import com.susancode.onlinebookstore.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    boolean existsByName(String name);

    boolean existsByUuid(UUID authorId);
    Optional<Author> findFirstByUuid(UUID authorId);
}
