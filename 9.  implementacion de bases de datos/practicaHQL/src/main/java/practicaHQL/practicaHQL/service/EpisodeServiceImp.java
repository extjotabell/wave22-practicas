package practicaHQL.practicaHQL.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import practicaHQL.practicaHQL.dto.EpisodeDto;
import practicaHQL.practicaHQL.entity.Episode;
import practicaHQL.practicaHQL.repository.EpisodeRepository;

import java.util.List;

@Service
public class EpisodeServiceImp implements EpisodeService{
    EpisodeRepository repo;
    ModelMapper modelMapper = new ModelMapper();

    public EpisodeServiceImp(EpisodeRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<EpisodeDto> episodeByActorName(String actor) {
        List<Episode> episodes = repo.allEpisodesByNameActor(actor);
        List<EpisodeDto> response = episodes.stream().map(e-> modelMapper.map(e, EpisodeDto.class)).toList();
        return response;
    }
}
