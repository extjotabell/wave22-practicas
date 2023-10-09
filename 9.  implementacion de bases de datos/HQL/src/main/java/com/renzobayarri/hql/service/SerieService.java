package com.renzobayarri.hql.service;

import com.renzobayarri.hql.dto.SerieDTO;
import com.renzobayarri.hql.entity.Serie;

import java.util.List;

public interface SerieService {

    List<SerieDTO> findAllByMinimumNumberOfSeasons(int numberOfSeasons);

    SerieDTO toDTO(Serie serie);
}
