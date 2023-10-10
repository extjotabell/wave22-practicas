package practicaHQL.practicaHQL.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import practicaHQL.practicaHQL.dto.MovieDto;
import practicaHQL.practicaHQL.entity.Movie;
import practicaHQL.practicaHQL.repository.MovieRepository;

import java.util.List;

@Service
public class MovieServiceImp implements MovieService{
    MovieRepository repo;
    ModelMapper modelMapper = new ModelMapper();

    public MovieServiceImp(MovieRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<MovieDto> moviesWithRatingMoreThan(double rating) {
        List<Movie> movies = repo.allMoviesWithRatingMoreThan(rating);
        List<MovieDto> response = movies.stream().map(m-> modelMapper.map(m,MovieDto.class)).toList();
        return response;
    }

    @Override
    public List<MovieDto> moviesByGenre(String genre) {
        List<Movie> movies = repo.allMoviesByGenre(genre);
        List<MovieDto> response = movies.stream().map(m-> modelMapper.map(m,MovieDto.class)).toList();
        return response;
    }
}
