package com.renzobayarri.hql.service;

import com.renzobayarri.hql.dto.SeasonDTO;
import com.renzobayarri.hql.entity.Season;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class SeasonServiceImpl implements SeasonService {

    private SerieService serieService;

    @Override
    public SeasonDTO toDTO(Season season) {
        ModelMapper mapper = new ModelMapper();
        SeasonDTO dto = mapper.map(season, SeasonDTO.class);
        dto.setSerie(serieService.toDTO(season.getSerie()));
        return dto;
    }
}
