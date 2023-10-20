package salvo.nicolas.movieshql.service;

import salvo.nicolas.movieshql.dto.ActorDTO;
import salvo.nicolas.movieshql.dto.EpisodeDTO;

import java.util.List;

public interface IEpisodeService {

    List<EpisodeDTO> findEpisodesByActorId(Integer actorId);
}
