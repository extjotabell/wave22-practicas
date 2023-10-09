package com.renzobayarri.hql.service;

import com.renzobayarri.hql.dto.GenreDTO;
import com.renzobayarri.hql.dto.SerieDTO;
import com.renzobayarri.hql.entity.Serie;
import com.renzobayarri.hql.repository.SerieRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SerieServiceImpl implements SerieService {

    private SerieRepository serieRepository;


    @Override
    public List<SerieDTO> findAllByMinimumNumberOfSeasons(int numberOfSeasons) {
        return serieRepository.findAllByMinimumNumberOfSeasons(numberOfSeasons).stream().map(this::toDTO).toList();
    }

    @Override
    public SerieDTO toDTO(Serie serie) {
        ModelMapper mapper = new ModelMapper();
        SerieDTO dto = mapper.map(serie, SerieDTO.class);
        dto.setGenre(mapper.map(serie.getGenre(), GenreDTO.class));
        return dto;
    }
}
