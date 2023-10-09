package com.example.demohibernate.repository;

import com.example.demohibernate.model.Jewerly;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JewerlyRepository extends JpaRepository<Jewerly, Long> {
}
