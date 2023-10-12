package com.example.ejercicio_extra.repository;

import com.example.ejercicio_extra.model.Cloth;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClothRepository extends JpaRepository<Cloth, String> {
    Cloth findClothByCode(String code);
    List<Cloth> findAllByTalle(String talle);
    List<Cloth> findAllByNombreContainsIgnoreCase(String word);
}
