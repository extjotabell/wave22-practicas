package com.renzobayarri.hql.service;

import com.renzobayarri.hql.dto.EpisodeDTO;
import com.renzobayarri.hql.entity.Episode;
import com.renzobayarri.hql.repository.EpisodeRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EpisodeServiceImpl implements EpisodeService {

    private EpisodeRepository episodeRepository;

    private SeasonService seasonService;

    @Override
    public List<EpisodeDTO> findAllByActorLastName(String lastName) {
        return episodeRepository.findAllByActorLastName(lastName).stream().map(this::toDTO).toList();
    }

    private EpisodeDTO toDTO(Episode episode) {
        ModelMapper mapper = new ModelMapper();
        EpisodeDTO dto = mapper.map(episode, EpisodeDTO.class);
        dto.setSeason(seasonService.toDTO(episode.getSeason()));
        return dto;
    }


}
