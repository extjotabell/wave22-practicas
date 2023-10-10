package com.example.joyeria.repository;

import com.example.joyeria.entity.Joya;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJoyeriaRepository extends JpaRepository<Joya,Long> {

}
