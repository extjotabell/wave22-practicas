package salvo.nicolas.testcases.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import salvo.nicolas.testcases.model.TestCase;

import java.time.LocalDate;
import java.util.List;

public interface ITestCaseRepository extends JpaRepository<TestCase, Long> {
    List<TestCase> findAllByLastUpdateIsAfter(LocalDate date);
}
