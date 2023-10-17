package com.example.movies.service;

import com.example.movies.dto.MovieDTO;

import java.util.List;

public interface IMovieService {
    MovieDTO createMovie(MovieDTO movieDTO);
    MovieDTO getMovieById(Integer id);
    List<MovieDTO> getAllMovies();
    MovieDTO updateMovie(Integer id, MovieDTO updatedMovieDTO);
    boolean deleteMovie(Integer id);
}
