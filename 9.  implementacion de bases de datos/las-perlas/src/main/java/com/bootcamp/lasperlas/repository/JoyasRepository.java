package com.bootcamp.lasperlas.repository;

import com.bootcamp.lasperlas.model.Joya;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface JoyasRepository extends JpaRepository<Joya, Long> {

    List<Joya> findAll();
    Joya findByNroIdentificatorio(Long id);
    Joya save(Joya j);
}
