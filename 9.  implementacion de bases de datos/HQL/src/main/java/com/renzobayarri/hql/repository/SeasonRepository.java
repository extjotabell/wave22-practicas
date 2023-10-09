package com.renzobayarri.hql.repository;

import com.renzobayarri.hql.entity.Season;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeasonRepository extends JpaRepository<Season, Integer> {
}