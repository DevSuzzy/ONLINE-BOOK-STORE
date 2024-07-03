package com.susancode.onlinebookstore.repository;

import com.susancode.onlinebookstore.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface GenreRepository extends JpaRepository<Genre, Long> {
    boolean existsByName(String name);

    Optional<Genre> findFirstByUuid(UUID id);
}
