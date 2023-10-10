package practicaHQL.practicaHQL.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import practicaHQL.practicaHQL.dto.ActorDto;
import practicaHQL.practicaHQL.entity.Actor;
import practicaHQL.practicaHQL.repository.ActorRepository;

import java.util.List;

@Service
public class ActorServiceImp implements ActorService{

    ActorRepository repo;

    ModelMapper modelMapper = new ModelMapper();

    public ActorServiceImp(ActorRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<ActorDto> actorWithFavoriteFilm() {
        List<Actor> actors = repo.allActorsWithFavoriteMovie();
        List<ActorDto> response = actors.stream().map(a -> modelMapper.map(a, ActorDto.class)).toList();
        return response;
    }

    @Override
    public List<ActorDto> actorsRatingMoreThan(double rating) {
        List<Actor> actors = repo.allActorsWithRatingMoreThan(rating);
        List<ActorDto> response = actors.stream().map(a -> modelMapper.map(a, ActorDto.class)).toList();
        return response;
    }

    @Override
    public List<ActorDto> actorsWorkInMovie(String movie) {
        List<Actor> actors = repo.allActorsWorkInMovie(movie);
        List<ActorDto> response = actors.stream().map(a-> modelMapper.map(a, ActorDto.class)).toList();
        return response;
    }
}
