package com.susancode.onlinebookstore.service.Impl;

import com.susancode.onlinebookstore.dto.request.GenreDTO;
import com.susancode.onlinebookstore.dto.response.ApiResponse;
import com.susancode.onlinebookstore.exception.NotFoundException;
import com.susancode.onlinebookstore.model.Genre;
import com.susancode.onlinebookstore.repository.GenreRepository;
import com.susancode.onlinebookstore.service.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {
    private final GenreRepository genreRepository;

    @Override
    public ApiResponse addGenre(GenreDTO genreDTO) {
        if (genreRepository.existsByName(genreDTO.getName()))
            throw new NotFoundException("Genre with name " + genreDTO.getName() + " already exists");
        {

        }
        Genre genre = convertToEntity(genreDTO);
        genreRepository.save(genre);
        return new ApiResponse(true, "Genre added successfully", genre);
    }

    @Override
    public ApiResponse fetchById(UUID id) {
        Genre genre = genreRepository.findFirstByUuid(id).orElseThrow(() -> new NotFoundException("Genre not found"));
        return new ApiResponse(true, "Genre fetched successfully", genre);

    }

    @Override
    public List<Genre> fetchAll() {
      return genreRepository.findAll();

    }

    @Override
    public ApiResponse updateGenre(UUID uuid, GenreDTO genreDTO) {
        Genre genre = genreRepository.findFirstByUuid(uuid).orElseThrow(() -> new NotFoundException("Genre not found"));
        genre.setName(genreDTO.getName());
        genre.setDescription(genreDTO.getDescription());
        genreRepository.save(genre);
        return new ApiResponse(true, "Genre updated successfully", genre);

    }

    @Override
    public ApiResponse deleteGenre(UUID uuid) {
        Genre genre = genreRepository.findFirstByUuid(uuid).orElseThrow(() -> new NotFoundException("Genre not found"));
        genreRepository.delete(genre);
        return new ApiResponse<>(true, "Genre deleted successfully", genre);
    }

    private Genre convertToEntity(GenreDTO genreDTO) {
        Genre genre = new Genre();
        genre.setName(genreDTO.getName());
        genre.setDescription(genreDTO.getDescription());
        genre.setUuid(UUID.randomUUID());
        return genre;
    }
}
