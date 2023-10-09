package com.renzobayarri.hql.service;

import com.renzobayarri.hql.dto.SeasonDTO;
import com.renzobayarri.hql.entity.Season;

public interface SeasonService {

    SeasonDTO toDTO(Season season);
}
