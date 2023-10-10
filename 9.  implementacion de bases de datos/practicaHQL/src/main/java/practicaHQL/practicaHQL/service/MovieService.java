package practicaHQL.practicaHQL.service;

import practicaHQL.practicaHQL.dto.MovieDto;

import java.util.List;

public interface MovieService {
    List<MovieDto> moviesWithRatingMoreThan(double rating);
    List<MovieDto> moviesByGenre(String genre);
}
