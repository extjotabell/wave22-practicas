package com.renzobayarri.hql.service;

import com.renzobayarri.hql.dto.ActorDTO;
import com.renzobayarri.hql.entity.Actor;

import java.util.List;

public interface ActorService {


    List<ActorDTO> actorsWithDeclararedFavoriteMovie();

    List<ActorDTO> findAllByFavoriteMovieIsNotNull();

    List<ActorDTO> actorsWithRatingGreaterThan(double rating);

    List<ActorDTO> findAllByRatingGreaterThan(double rating);

    List<ActorDTO> actorsThatWorkInAMovie(String title);

    List<ActorDTO> findAllByActorMovie_movie_title(String title);
}
