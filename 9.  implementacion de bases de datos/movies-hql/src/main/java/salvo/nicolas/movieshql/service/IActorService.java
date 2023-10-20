package salvo.nicolas.movieshql.service;

import salvo.nicolas.movieshql.dto.ActorDTO;

import java.util.List;

public interface IActorService {

    List<ActorDTO> findActorsThatHaveFavoriteMovie();

    List<ActorDTO> findActorsWithRankingOf(Double rating);

    List<ActorDTO> findActorsThatWorksInMovie(Integer movieId);
}
