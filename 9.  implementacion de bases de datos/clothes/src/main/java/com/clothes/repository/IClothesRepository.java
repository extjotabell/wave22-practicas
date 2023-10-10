package com.clothes.repository;

import com.clothes.model.Clothes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IClothesRepository extends JpaRepository<Clothes, Long> {
    List<Clothes> findAllBySize(String size);
    List<Clothes> findAllByNameContainingIgnoreCase(String name);
}
