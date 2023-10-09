package com.renzobayarri.hql.repository;

import com.renzobayarri.hql.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

    /**
     * @param rating mínimo de los actores (no incluido)
     * @return todas las películas cuyos actores tengan rating superior al valor recibido por parámetro
     */
    @Query("FROM Movie m JOIN ActorMovie am ON m = am.movie JOIN Actor a ON a = am.actor WHERE a.rating > :rating")
    List<Movie> findAllByActorsRatingGreaterThan(@Param("rating") double rating);

    /**
     * @param genreName
     * @return todas las películas que pertenezcan al género recibido por parámetro
     */
    @Query("FROM Movie m WHERE m.genre.name = :genre")
    List<Movie> findAllByGenre(@Param("genre") String genreName);

    List<Movie> findAllByGenreName(String genreName);
}