package com.example.demo.service;

import com.example.demo.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private final StudentRepository stuRepo;

    public StudentService(StudentRepository stuRepo){
        this.stuRepo = stuRepo;
    }
}
