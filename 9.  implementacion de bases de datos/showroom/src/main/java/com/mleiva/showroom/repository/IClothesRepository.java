package com.mleiva.showroom.repository;

import com.mleiva.showroom.entity.Clothes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IClothesRepository extends JpaRepository<Clothes, Long> {

    List<Clothes> findAllByTalle(String talle);
    List<Clothes> findAllByNombreContainingIgnoreCase(String nombre);

}
