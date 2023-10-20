package salvo.nicolas.movieshql.service;

import salvo.nicolas.movieshql.dto.ActorDTO;
import salvo.nicolas.movieshql.dto.MovieDTO;

import java.util.List;

public interface IMovieService {

    List<MovieDTO> findMoviesThatActorsHaveRankingGreaterThan(Double rating);

    List<MovieDTO> findMoviesOfGenreId(Integer genreId);
}
