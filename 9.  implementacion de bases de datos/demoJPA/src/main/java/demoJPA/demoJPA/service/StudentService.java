package demoJPA.demoJPA.service;

import demoJPA.demoJPA.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private final StudentRepository stuRepo;

    public StudentService(StudentRepository stuRepo) {
        this.stuRepo = stuRepo;
    }
}
