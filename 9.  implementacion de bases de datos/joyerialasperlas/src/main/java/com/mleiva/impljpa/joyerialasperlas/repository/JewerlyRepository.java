package com.mleiva.impljpa.joyerialasperlas.repository;

import com.mleiva.impljpa.joyerialasperlas.model.Jewerly;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JewerlyRepository extends JpaRepository<Jewerly, Long> {
}
