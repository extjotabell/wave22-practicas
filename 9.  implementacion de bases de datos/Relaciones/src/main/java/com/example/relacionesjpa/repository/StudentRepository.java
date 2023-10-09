package com.example.relacionesjpa.repository;

import com.example.relacionesjpa.entity.ManyToMany.StudentManyToMany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentManyToMany,Long> {
}
