package com.example.ejemploconexionmysql.service;

import com.example.ejemploconexionmysql.dto.StudentDTO;
import com.example.ejemploconexionmysql.model.Student;
import com.example.ejemploconexionmysql.repository.StudentRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private  final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    public Student save(StudentDTO studentDTO) {
        ObjectMapper mapper = new ObjectMapper();
        Student student = mapper.convertValue(studentDTO, Student.class);
        return studentRepository.save(student);
    }
}
