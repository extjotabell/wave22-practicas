package com.example.demo.service;

import com.example.demo.dto.TestCaseDTO;

import java.time.LocalDate;
import java.util.List;

public interface ITestCaseService {
    TestCaseDTO create(TestCaseDTO testCaseDTO);

    List<TestCaseDTO> getAll();

    TestCaseDTO getById(Long id);

    TestCaseDTO update(Long id, TestCaseDTO testCaseDTO);

    boolean delete(Long id);

    List<TestCaseDTO> getByLastUpdate(LocalDate lastUpdate);
}
