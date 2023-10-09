package com.renzobayarri.hql.repository;

import com.renzobayarri.hql.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ActorRepository extends JpaRepository<Actor, Integer> {

    /**
     * @return todos los actores que tengan declarada una película favorita
     */
    @Query("FROM Actor a WHERE a.favoriteMovie IS NOT NULL")
    List<Actor> actorsWithDeclararedFavoriteMovie();

    List<Actor> findAllByFavoriteMovieIsNotNull();

    /**
     * @param rating mínimo
     * @return todos los actores que tengan rating superior al valor recibido por parámetro
     */
    @Query("FROM Actor a WHERE a.rating > :rating")
    List<Actor> actorsWithRatingGreaterThan(@Param("rating") double rating);

    List<Actor> findAllByRatingGreaterThan(double rating);

    /**
     * @param title de la película cuyos actores se desean buscar
     * @return todos los actores que trabajan en la película recibida por parámetro
     */
    @Query("FROM Actor a JOIN ActorMovie am ON a = am.actor WHERE am.movie.title = :title")
    List<Actor> actorsThatWorkInAMovie(@Param("title") String title);

    List<Actor> findAllByActorMovie_movie_title(String title);
}