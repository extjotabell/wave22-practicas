package com.miniseries.demo.repository;

import com.miniseries.demo.model.MiniSerie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MiniSerieRepository extends JpaRepository<MiniSerie, Long> {
}