package com.example.relacionesjpa.repository;

import com.example.relacionesjpa.entity.ManyToMany.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {
}
