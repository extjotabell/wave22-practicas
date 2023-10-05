package com.example.JpaPlusHibernate.service;

import com.example.JpaPlusHibernate.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private final StudentRepository stuRepo;

    public StudentService(StudentRepository stuRepo){
        this.stuRepo = stuRepo;
    }
}
