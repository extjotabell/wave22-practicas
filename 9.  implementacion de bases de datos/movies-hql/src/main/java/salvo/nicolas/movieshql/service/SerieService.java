package salvo.nicolas.movieshql.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import salvo.nicolas.movieshql.dto.SerieDTO;
import salvo.nicolas.movieshql.model.Serie;
import salvo.nicolas.movieshql.repository.SerieRepository;

import java.util.List;

@Service
public class SerieService implements ISerieService {
    private final SerieRepository serieRepository;
    private final ModelMapper mapper = new ModelMapper();

    public SerieService(SerieRepository serieRepository) {
        this.serieRepository = serieRepository;
    }

    @Override
    public List<SerieDTO> findSeriesThatSeasonsGreaterThan(Integer seasonNumber) {
        List<Serie> seriesThatSeasonsGreaterThan = serieRepository.findSeriesThatSeasonsGreaterThan(seasonNumber);
        return seriesThatSeasonsGreaterThan.stream().map(this::toDTO).toList();
    }

    private SerieDTO toDTO(Serie serie) {
        return mapper.map(serie, SerieDTO.class);
    }

    private Serie toEntity(SerieDTO serieDTO) {
        return mapper.map(serieDTO, Serie.class);
    }

}
