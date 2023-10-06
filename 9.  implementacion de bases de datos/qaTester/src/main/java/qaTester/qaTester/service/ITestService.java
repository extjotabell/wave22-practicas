package qaTester.qaTester.service;

import qaTester.qaTester.dto.TestCaseDto;

import java.time.LocalDate;
import java.util.List;

public interface ITestService {
    void createTestCase(TestCaseDto testCaseDto);
    List<TestCaseDto> getTestCases();
    TestCaseDto getTestCaseById(long id);
    void updateTestCase(long id, TestCaseDto testCaseDto);
    void deleteTestCase(long id);
    List<TestCaseDto> getTestCasesByDate(LocalDate date);
}
