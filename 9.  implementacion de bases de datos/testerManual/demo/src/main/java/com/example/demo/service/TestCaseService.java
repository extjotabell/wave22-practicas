package com.example.demo.service;

import com.example.demo.dto.TestCaseDTO;
import com.example.demo.model.TestCase;
import com.example.demo.repository.TestCaseRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TestCaseService implements ITestCaseService{
    private final TestCaseRepository testCaseRepository;

    public TestCaseService(TestCaseRepository testCaseRepository) {
        this.testCaseRepository = testCaseRepository;
    }

    @Override
    public TestCaseDTO create(TestCaseDTO testCaseDTO) {
        TestCase testCase = new TestCase();
        testCase.setDescription(testCaseDTO.getDescription());
        testCase.setTested(testCaseDTO.getTested());
        testCase.setPassed(testCaseDTO.getPassed());
        testCase.setNumber_of_tries(testCaseDTO.getNumber_of_tries());
        testCase.setLastUpdate(testCaseDTO.getLastUpdate());

        TestCase savedTestCase = testCaseRepository.save(testCase);

        return convertToDTO(savedTestCase);
    }

    @Override
    public List<TestCaseDTO> getAll() {
        List<TestCase> testCases = testCaseRepository.findAll();
        return testCases.stream().map(this::convertToDTO).toList();
    }

    @Override
    public TestCaseDTO getById(Long id) {
        Optional<TestCase> testCaseOptional = testCaseRepository.findById(id);
        return testCaseOptional.map(this::convertToDTO).orElse(null);
    }

    @Override
    public TestCaseDTO update(Long id, TestCaseDTO testCaseDTO) {
        Optional<TestCase> existingTestCaseOptional = testCaseRepository.findById(id);
        if (existingTestCaseOptional.isPresent()) {
            TestCase existingTestCase = existingTestCaseOptional.get();
            existingTestCase.setDescription(testCaseDTO.getDescription());
            existingTestCase.setTested(testCaseDTO.getTested());
            existingTestCase.setPassed(testCaseDTO.getPassed());
            existingTestCase.setNumber_of_tries(testCaseDTO.getNumber_of_tries());
            existingTestCase.setLastUpdate(testCaseDTO.getLastUpdate());

            TestCase updatedTestCase = testCaseRepository.save(existingTestCase);
            return convertToDTO(updatedTestCase);
        }
        return null;
    }

    @Override
    public boolean delete(Long id) {
        if (testCaseRepository.existsById(id)) {
            testCaseRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<TestCaseDTO> getByLastUpdate(LocalDate lastUpdate) {
        List<TestCase> testCases = testCaseRepository.findByLastUpdateAfter(lastUpdate);
        return testCases.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private TestCaseDTO convertToDTO(TestCase testCase) {
        TestCaseDTO testCaseDTO = new TestCaseDTO();
        testCaseDTO.setDescription(testCase.getDescription());
        testCaseDTO.setTested(testCase.getTested());
        testCaseDTO.setPassed(testCase.getPassed());
        testCaseDTO.setNumber_of_tries(testCase.getNumber_of_tries());
        testCaseDTO.setLastUpdate(testCase.getLastUpdate());
        return testCaseDTO;
    }
}
