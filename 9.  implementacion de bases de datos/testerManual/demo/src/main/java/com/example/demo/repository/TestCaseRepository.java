package com.example.demo.repository;

import com.example.demo.model.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TestCaseRepository extends JpaRepository<TestCase, Long> {
    List<TestCase> findByLastUpdateAfter(LocalDate lastUpdate);

}
