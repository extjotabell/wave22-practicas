package practicaHQL.practicaHQL.service;

import practicaHQL.practicaHQL.dto.SerieDto;

import java.util.List;

public interface SerieService {
    List<SerieDto> seriesBySeasonsMoreThan(int number_seasons);
}
