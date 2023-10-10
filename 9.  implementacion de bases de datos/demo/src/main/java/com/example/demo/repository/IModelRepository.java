package com.example.demo.repository;

import com.example.demo.model.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IModelRepository extends JpaRepository<Model,Long> {
}
