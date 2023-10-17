package com.example.movies.controller;

import com.example.movies.dto.MovieDTO;
import com.example.movies.service.IMovieService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class MoviesController {
    private final IMovieService movieService;

    public MoviesController(IMovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping("/new")
    public ResponseEntity<MovieDTO> createMovie(@RequestBody MovieDTO movieDTO) {
        MovieDTO createdMovie = movieService.createMovie(movieDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMovie);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDTO> getMovieById(@PathVariable Integer id) {
        MovieDTO movie = movieService.getMovieById(id);
        if (movie != null) {
            return ResponseEntity.ok(movie);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<MovieDTO>> getAllMovies() {
        List<MovieDTO> movies = movieService.getAllMovies();
        return ResponseEntity.ok(movies);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieDTO> updateMovie(@PathVariable Integer id, @RequestBody MovieDTO updatedMovieDTO) {
        MovieDTO movie = movieService.updateMovie(id, updatedMovieDTO);
        if (movie != null) {
            return ResponseEntity.ok(movie);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Integer id) {
        boolean deleted = movieService.deleteMovie(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
