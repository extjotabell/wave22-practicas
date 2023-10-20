package salvo.nicolas.movieshql.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import salvo.nicolas.movieshql.dto.MovieDTO;
import salvo.nicolas.movieshql.model.Movie;
import salvo.nicolas.movieshql.repository.MovieRepository;

import java.util.List;

@Service
public class MovieService implements IMovieService {
    private final MovieRepository movieRepository;
    private final ModelMapper mapper = new ModelMapper();

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<MovieDTO> findMoviesThatActorsHaveRankingGreaterThan(Double rating) {
        List<Movie> moviesThatActorsHaveRankingGreaterThan = movieRepository.findMoviesThatActorsHaveRankingGreaterThan(rating);
        return moviesThatActorsHaveRankingGreaterThan.stream().map(this::toDTO).toList();
    }

    @Override
    public List<MovieDTO> findMoviesOfGenreId(Integer genreId) {
        List<Movie> moviesThatGenreIs = movieRepository.findMoviesThatGenreIs(genreId);
        return moviesThatGenreIs.stream().map(this::toDTO).toList();
    }

    private MovieDTO toDTO(Movie actor) {
        return mapper.map(actor, MovieDTO.class);
    }

    private Movie toEntity(MovieDTO movieDTO) {
        return mapper.map(movieDTO, Movie.class);
    }

}
