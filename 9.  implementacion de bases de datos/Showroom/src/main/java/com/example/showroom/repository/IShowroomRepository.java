package com.example.showroom.repository;

import com.example.showroom.entity.Clothes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface IShowroomRepository extends JpaRepository<Clothes,Long> {
    Clothes findByCode(String code);
    void deleteByCode(String code);
    List<Clothes> findAllBySize(String size);
}
