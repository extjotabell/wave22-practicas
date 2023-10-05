package com.mleiva.implementacionjpa.service;

import com.mleiva.implementacionjpa.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

}
