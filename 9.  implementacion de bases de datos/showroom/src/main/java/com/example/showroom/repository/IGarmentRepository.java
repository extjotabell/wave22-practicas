package com.example.showroom.repository;
import com.example.showroom.dto.GarmentDTO;
import com.example.showroom.entity.Garment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IGarmentRepository extends JpaRepository<Garment, Long> {

    List<Garment> findAllByNameContaining(String name);

    List<Garment> findAllBySize(String size);

}
