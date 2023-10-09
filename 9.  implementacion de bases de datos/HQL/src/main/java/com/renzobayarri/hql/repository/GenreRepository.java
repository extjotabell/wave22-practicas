package com.renzobayarri.hql.repository;

import com.renzobayarri.hql.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Integer> {
}