package demoJPA.demoJPA.repository;

import demoJPA.demoJPA.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository <Student,Long> {
}
