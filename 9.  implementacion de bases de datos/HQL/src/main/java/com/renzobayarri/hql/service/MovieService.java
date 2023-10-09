package com.renzobayarri.hql.service;

import com.renzobayarri.hql.dto.MovieDTO;
import com.renzobayarri.hql.entity.Movie;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieService {

    List<MovieDTO> findAllByActorsRatingGreaterThan(double rating);

    List<MovieDTO> findAllByGenre(String genreName);

    List<MovieDTO> findAllByGenreName(String genreName);

    MovieDTO toDTO(Movie movie);
}
