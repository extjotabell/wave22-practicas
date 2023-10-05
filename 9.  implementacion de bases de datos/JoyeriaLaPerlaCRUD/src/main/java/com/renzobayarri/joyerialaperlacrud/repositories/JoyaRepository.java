package com.renzobayarri.joyerialaperlacrud.repositories;

import com.renzobayarri.joyerialaperlacrud.entities.Joya;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JoyaRepository extends JpaRepository<Joya, Long> {

    List<Joya> findAllByVentaONoTrue();

}
