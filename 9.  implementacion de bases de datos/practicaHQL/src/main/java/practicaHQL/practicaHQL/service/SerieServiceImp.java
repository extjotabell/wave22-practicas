package practicaHQL.practicaHQL.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import practicaHQL.practicaHQL.dto.SerieDto;
import practicaHQL.practicaHQL.entity.Serie;
import practicaHQL.practicaHQL.repository.SerieRepository;

import java.util.List;

@Service
public class SerieServiceImp implements SerieService{
    SerieRepository repo;
    ModelMapper modelMapper = new ModelMapper();

    public SerieServiceImp(SerieRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<SerieDto> seriesBySeasonsMoreThan(int number_seasons) {
        List<Serie> series = repo.allSeriesWithMoreSeasonsThan(number_seasons);
        List<SerieDto> response = series.stream().map(s-> modelMapper.map(s, SerieDto.class)).toList();
        return response;
    }
}
