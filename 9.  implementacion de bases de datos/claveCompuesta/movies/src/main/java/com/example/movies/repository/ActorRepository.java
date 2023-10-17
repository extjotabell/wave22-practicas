package com.example.movies.repository;

import com.example.movies.model.Actor;
import com.example.movies.model.Movie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorRepository extends CrudRepository<Actor, Integer> {
    @Query("SELECT a FROM Actor a WHERE a.favoriteMovieId IS NOT NULL")
    List<Actor> findAllActorsWithFavoriteMovie();
    @Query("SELECT a FROM Actor a WHERE a.rating > :rating")
    List<Actor> findAllActorsWithRatingGreaterThan(@Param("rating") double rating);
    @Query("SELECT a FROM Actor a WHERE a.favoriteMovieId = :movieId")
    List<Actor> findAllActorsInMovie(@Param("movieId") int movieId);
}
