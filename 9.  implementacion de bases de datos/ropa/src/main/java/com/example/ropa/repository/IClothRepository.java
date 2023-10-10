package com.example.ropa.repository;

import com.example.ropa.entity.Cloth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IClothRepository extends JpaRepository<Cloth,Integer> {

    List<Cloth> findBySize(Integer size);

    List<Cloth> findByNameContainsIgnoreCase(String name);
}
