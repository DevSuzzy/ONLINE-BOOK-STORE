package com.susancode.onlinebookstore.controller;

import com.susancode.onlinebookstore.dto.request.GenreDTO;
import com.susancode.onlinebookstore.dto.response.ApiResponse;
import com.susancode.onlinebookstore.model.Genre;
import com.susancode.onlinebookstore.service.GenreService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/genres")
@RequiredArgsConstructor
public class GenreController {
    private final GenreService genreService;

    @PostMapping
    public ApiResponse addGenre(@RequestBody @Valid GenreDTO genreDTO) {
        return genreService.addGenre(genreDTO);
    }
    @GetMapping("/uuid")
    public ApiResponse fetchById(@RequestParam("uui") UUID uuid) {
        return genreService.fetchById(uuid);
    }
    @GetMapping("/all")
    public List<Genre> fetchAllGenre() {
        return genreService.fetchAll();
    }

   @PutMapping("/uuid")
    public ApiResponse updateGenre(@RequestParam("uuid") UUID uuid, @RequestBody @Valid GenreDTO genreDTO) {
        return genreService.updateGenre(uuid, genreDTO);
    }
    @DeleteMapping("/uuid")
    public ApiResponse deleteGenre(@RequestParam("uuid") UUID uuid) {
        return genreService.deleteGenre(uuid);
    }
}
