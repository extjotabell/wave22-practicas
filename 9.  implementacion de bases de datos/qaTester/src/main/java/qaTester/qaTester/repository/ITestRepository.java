package qaTester.qaTester.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import qaTester.qaTester.model.TestCase;

@Repository
public interface ITestRepository extends JpaRepository<TestCase, Long> {
}
