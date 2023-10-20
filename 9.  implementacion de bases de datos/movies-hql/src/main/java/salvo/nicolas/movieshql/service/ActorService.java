package salvo.nicolas.movieshql.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import salvo.nicolas.movieshql.dto.ActorDTO;
import salvo.nicolas.movieshql.model.Actor;
import salvo.nicolas.movieshql.repository.ActorRepository;

import java.util.List;

@Service
public class ActorService implements IActorService {
    private final ActorRepository actorRepository;
    private final ModelMapper mapper = new ModelMapper();

    public ActorService(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @Override
    public List<ActorDTO> findActorsThatHaveFavoriteMovie() {
        List<Actor> allByMoviesIsNotNull = actorRepository.findAllByMoviesIsNotNull();
        return allByMoviesIsNotNull.stream().map(this::toDTO).toList();
    }

    @Override
    public List<ActorDTO> findActorsWithRankingOf(Double rating) {
        List<Actor> allByRatingIsGreaterThan = actorRepository.findAllByRatingIsGreaterThan(rating);
        return allByRatingIsGreaterThan.stream().map(this::toDTO).toList();
    }

    @Override
    public List<ActorDTO> findActorsThatWorksInMovie(Integer movieId) {
        List<Actor> allByMoviesIs = actorRepository.findAllByMoviesContains(movieId);
        return allByMoviesIs.stream().map(this::toDTO).toList();
    }

    private ActorDTO toDTO(Actor actor) {
        return mapper.map(actor, ActorDTO.class);
    }

    private Actor toEntity(ActorDTO actorDTO) {
        return mapper.map(actorDTO, Actor.class);
    }

}
