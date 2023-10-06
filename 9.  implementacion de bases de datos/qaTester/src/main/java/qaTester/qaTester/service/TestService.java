package qaTester.qaTester.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import qaTester.qaTester.dto.TestCaseDto;
import qaTester.qaTester.exception.IdNotExistsException;
import qaTester.qaTester.model.TestCase;
import qaTester.qaTester.repository.ITestRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class TestService implements ITestService {

    private final ITestRepository repository;
    private ObjectMapper mapper = new ObjectMapper();

    public TestService(ITestRepository repository) {
        this.repository = repository;
    }

    @Override
    public void createTestCase(TestCaseDto testCaseDto) {
        repository.save(mapper.convertValue(testCaseDto, TestCase.class));
    }

    @Override
    public List<TestCaseDto> getTestCases() {
        return repository.findAll().stream()
                .map(tc -> mapper.convertValue(tc, TestCaseDto.class))
                .toList();
    }

    @Override
    public TestCaseDto getTestCaseById(long id) {
        TestCase dbTestCase = repository.findById(id).orElse(null);
        if(dbTestCase == null){
            throw new IdNotExistsException("Test case with id " + id + " does not exists");
        }
        return mapper.convertValue(dbTestCase, TestCaseDto.class);
    }

    @Override
    public void updateTestCase(long id, TestCaseDto testCaseDto) {
        TestCase dbTestCase = repository.findById(id).orElse(null);
        if(dbTestCase == null){
            throw new IdNotExistsException("Test case with id " + id + " does not exists");
        }
        if(testCaseDto.getDescription() != null){
            dbTestCase.setDescription(testCaseDto.getDescription());
        }
        if(testCaseDto.getNumberOfTries() > 0){
            dbTestCase.setNumberOfTries(testCaseDto.getNumberOfTries());
        }
        if(testCaseDto.getLastUpdate() != null){
            dbTestCase.setLastUpdate(testCaseDto.getLastUpdate());
        }
        dbTestCase.setPassed(testCaseDto.isPassed());
        dbTestCase.setTested(testCaseDto.isTested());

        repository.save(dbTestCase);
    }

    @Override
    public void deleteTestCase(long id) {
        repository.deleteById(id);
    }

    @Override
    public List<TestCaseDto> getTestCasesByDate(LocalDate date) {
        return repository.findAll().stream()
                .filter(tc -> tc.getLastUpdate().isAfter(date))
                .map(tc -> mapper.convertValue(tc, TestCaseDto.class))
                .toList();
    }
}
