package com.example.joyeria_las_perlas.repository;

import com.example.joyeria_las_perlas.entity.Jewel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JewelRepository extends JpaRepository<Jewel, Long> {
}
