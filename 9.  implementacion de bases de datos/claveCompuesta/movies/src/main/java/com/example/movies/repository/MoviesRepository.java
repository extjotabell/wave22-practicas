package com.example.movies.repository;

import com.example.movies.model.Movie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MoviesRepository extends CrudRepository<Movie, Integer> {
   @Query("SELECT m FROM Movie m WHERE m.id IN (SELECT a.favoriteMovieId FROM Actor a WHERE a.rating > :rating)")
   List<Movie> findMoviesWithActorsRatingGreaterThan(@Param("rating") double rating);
    @Query("SELECT m FROM Movie m WHERE m.genreId = :genreId")
    List<Movie> findMoviesByGenre(@Param("genreId") int genreId);
}
