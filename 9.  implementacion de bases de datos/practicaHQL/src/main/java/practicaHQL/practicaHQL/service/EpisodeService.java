package practicaHQL.practicaHQL.service;

import practicaHQL.practicaHQL.dto.EpisodeDto;

import java.util.List;

public interface EpisodeService {
    List<EpisodeDto> episodeByActorName(String actor);
}
