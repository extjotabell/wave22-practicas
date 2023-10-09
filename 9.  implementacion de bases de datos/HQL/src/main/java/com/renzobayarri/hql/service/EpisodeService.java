package com.renzobayarri.hql.service;

import com.renzobayarri.hql.dto.EpisodeDTO;
import com.renzobayarri.hql.entity.Episode;

import java.util.List;

public interface EpisodeService {

    List<EpisodeDTO> findAllByActorLastName(String lastName);
}
