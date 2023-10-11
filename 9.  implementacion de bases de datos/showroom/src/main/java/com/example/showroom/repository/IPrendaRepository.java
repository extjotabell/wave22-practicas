package com.example.showroom.repository;

import com.example.showroom.entity.Prenda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPrendaRepository extends JpaRepository<Prenda, Integer> {
    public List<Prenda> findPrendasByTalle(String talle);
    public List<Prenda> findPrendasByNombreContains(String contains);
}
