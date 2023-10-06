package com.renzobayarri.clavecompuesta.repository;

import com.renzobayarri.clavecompuesta.entity.Compra;
import com.renzobayarri.clavecompuesta.entity.CompraKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompraRepository extends JpaRepository<Compra, CompraKey> {
}
