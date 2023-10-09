package com.renzobayarri.hql.service;

import com.renzobayarri.hql.dto.ActorDTO;
import com.renzobayarri.hql.entity.Actor;
import com.renzobayarri.hql.repository.ActorRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ActorServiceImpl implements ActorService {

    private ActorRepository actorRepository;

    private MovieService movieService;

    @Override
    public List<ActorDTO> actorsWithDeclararedFavoriteMovie() {
        return actorRepository.actorsWithDeclararedFavoriteMovie().stream().map(this::toDTO).toList();
    }

    @Override
    public List<ActorDTO> findAllByFavoriteMovieIsNotNull() {
        return actorRepository.findAllByFavoriteMovieIsNotNull().stream().map(this::toDTO).toList();
    }

    @Override
    public List<ActorDTO> actorsWithRatingGreaterThan(double rating) {
        return actorRepository.actorsWithRatingGreaterThan(rating).stream().map(this::toDTO).toList();
    }

    @Override
    public List<ActorDTO> findAllByRatingGreaterThan(double rating) {
        return actorRepository.findAllByRatingGreaterThan(rating).stream().map(this::toDTO).toList();
    }

    @Override
    public List<ActorDTO> actorsThatWorkInAMovie(String title) {
        return actorRepository.actorsThatWorkInAMovie(title).stream().map(this::toDTO).toList();
    }

    @Override
    public List<ActorDTO> findAllByActorMovie_movie_title(String title) {
        return actorRepository.findAllByActorMovie_movie_title(title).stream().map(this::toDTO).toList();
    }

    private ActorDTO toDTO(Actor actor) {
        ModelMapper mapper = new ModelMapper();
        ActorDTO dto = mapper.map(actor, ActorDTO.class);
        dto.setFavoriteMovie(movieService.toDTO(actor.getFavoriteMovie()));
        return dto;
    }
}
