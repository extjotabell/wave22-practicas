package salvo.nicolas.movieshql.service;

import salvo.nicolas.movieshql.dto.SerieDTO;

import java.util.List;

public interface ISerieService {

    List<SerieDTO> findSeriesThatSeasonsGreaterThan(Integer seasonNumber);
}
