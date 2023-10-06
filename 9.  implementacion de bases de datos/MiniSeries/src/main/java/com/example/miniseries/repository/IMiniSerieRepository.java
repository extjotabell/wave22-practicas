package com.example.miniseries.repository;

import com.example.miniseries.model.MiniSerie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMiniSerieRepository extends JpaRepository<MiniSerie,Long> {
}
