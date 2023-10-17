package com.example.movies.service;

import com.example.movies.dto.MovieDTO;
import com.example.movies.model.Movie;
import com.example.movies.repository.MoviesRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MovieService implements IMovieService {
    private final MoviesRepository movieRepository;
    private final ModelMapper modelMapper;

    public MovieService(MoviesRepository movieRepository, ModelMapper modelMapper) {
        this.movieRepository = movieRepository;
        this.modelMapper = modelMapper;
    }

    public MovieDTO createMovie(MovieDTO movieDTO) {
        Movie movie = modelMapper.map(movieDTO, Movie.class);
        Movie createdMovie = movieRepository.save(movie);
        return modelMapper.map(createdMovie, MovieDTO.class);
    }

    public MovieDTO getMovieById(Integer id) {
        Optional<Movie> optionalMovie = movieRepository.findById(id);
        return optionalMovie.map(movie -> modelMapper.map(movie, MovieDTO.class)).orElse(null);
    }

    public List<MovieDTO> getAllMovies() {
        List<Movie> movies = (List<Movie>) movieRepository.findAll();
        return movies.stream()
                .map(movie -> modelMapper.map(movie, MovieDTO.class))
                .toList();
    }

    public MovieDTO updateMovie(Integer id, MovieDTO updatedMovieDTO) {
        Optional<Movie> optionalMovie = movieRepository.findById(id);
        if (optionalMovie.isPresent()) {
            Movie updatedMovie = optionalMovie.get();
            modelMapper.map(updatedMovieDTO, updatedMovie);
            movieRepository.save(updatedMovie);
            return modelMapper.map(updatedMovie, MovieDTO.class);
        }
        return null;
    }

    public boolean deleteMovie(Integer id) {
        if (movieRepository.existsById(id)) {
            movieRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
