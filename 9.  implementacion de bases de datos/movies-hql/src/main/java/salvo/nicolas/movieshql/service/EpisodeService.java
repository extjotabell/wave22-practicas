package salvo.nicolas.movieshql.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import salvo.nicolas.movieshql.dto.EpisodeDTO;
import salvo.nicolas.movieshql.model.Actor;
import salvo.nicolas.movieshql.model.Episode;
import salvo.nicolas.movieshql.repository.EpisodeRepository;

import java.util.List;

@Service
public class EpisodeService implements IEpisodeService {
    private final EpisodeRepository episodeRepository;
    private final ModelMapper mapper = new ModelMapper();

    public EpisodeService(EpisodeRepository episodeRepository) {
        this.episodeRepository = episodeRepository;
    }

    @Override
    public List<EpisodeDTO> findEpisodesByActorId(Integer actorId) {
        List<Episode> episodesByActorId = episodeRepository.findEpisodesByActorId(actorId);
        return episodesByActorId.stream().map(episode -> mapper.map(episode, EpisodeDTO.class)).toList();
    }

    private EpisodeDTO toDTO(Episode episode) {
        return mapper.map(episode, EpisodeDTO.class);
    }

    private Episode toEntity(EpisodeDTO episodeDTO) {
        return mapper.map(episodeDTO, Episode.class);
    }

}
