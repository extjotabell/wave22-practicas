package com.example.ropa.repository;


import com.example.ropa.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ISaleRepository extends JpaRepository<Sale, Integer> {

    List<Sale> findByDate(LocalDate date);
}
