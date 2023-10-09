package com.renzobayarri.hql.repository;

import com.renzobayarri.hql.entity.ActorMovie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorMovieRepository extends JpaRepository<ActorMovie, Integer> {
}