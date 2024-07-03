package com.susancode.onlinebookstore.service;

import com.susancode.onlinebookstore.dto.request.GenreDTO;
import com.susancode.onlinebookstore.dto.response.ApiResponse;
import com.susancode.onlinebookstore.model.Genre;

import java.util.List;
import java.util.UUID;

public interface GenreService {
    ApiResponse addGenre(GenreDTO genreDTO);

    ApiResponse fetchById(UUID id);

    List<Genre> fetchAll();

    ApiResponse updateGenre(UUID uuid, GenreDTO genreDTO);

    ApiResponse deleteGenre(UUID uuid);
}
