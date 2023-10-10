package practicaHQL.practicaHQL.service;

import practicaHQL.practicaHQL.dto.ActorDto;

import java.util.List;

public interface ActorService {
    List<ActorDto> actorWithFavoriteFilm();
    List<ActorDto> actorsRatingMoreThan(double rating);
    List<ActorDto> actorsWorkInMovie(String movie);
}
