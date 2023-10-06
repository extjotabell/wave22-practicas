package com.meli.joyerialasperlas.repository;

import com.meli.joyerialasperlas.model.Joya;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JoyaRepository extends JpaRepository<Joya, Long> {

}
