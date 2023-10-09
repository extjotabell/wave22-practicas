package com.renzobayarri.hql.service;

import com.renzobayarri.hql.dto.GenreDTO;
import com.renzobayarri.hql.dto.MovieDTO;
import com.renzobayarri.hql.entity.Movie;
import com.renzobayarri.hql.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MovieServiceImpl implements MovieService {

    private MovieRepository movieRepository;

    @Override
    public List<MovieDTO> findAllByActorsRatingGreaterThan(double rating) {
        return movieRepository.findAllByActorsRatingGreaterThan(rating).stream().map(this::toDTO).toList();
    }

    @Override
    public List<MovieDTO> findAllByGenre(String genreName) {
        return movieRepository.findAllByGenre(genreName).stream().map(this::toDTO).toList();
    }

    @Override
    public List<MovieDTO> findAllByGenreName(String genreName) {
        return movieRepository.findAllByGenreName(genreName).stream().map(this::toDTO).toList();
    }

    public MovieDTO toDTO(Movie movie) {
        ModelMapper mapper = new ModelMapper();
        MovieDTO dto = mapper.map(movie, MovieDTO.class);
        dto.setGenre(mapper.map(movie.getGenre(), GenreDTO.class));
        return dto;
    }
}
