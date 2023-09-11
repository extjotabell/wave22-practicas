package com.sistemaEstudiantes.sistemaEstudiantes.service;

import com.sistemaEstudiantes.sistemaEstudiantes.dto.StudentDTO;
import com.sistemaEstudiantes.sistemaEstudiantes.model.Student;
import com.sistemaEstudiantes.sistemaEstudiantes.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService implements IStudentService {

    @Autowired
    IStudentRepository repository;

    @Override
    public List<StudentDTO> getAllStudents() {
        List<Student> studentsList = repository.getAllStudents();
        List<StudentDTO> studentDTOList = studentsList.stream()
                .map(student -> new StudentDTO(student.getId(), student.getName(),
                        student.getLastname(), student.getDni()))
                .collect(Collectors.toList());
        return studentDTOList;
    }

    @Override
    public void uploadStudent(StudentDTO studentDTO) {
        repository.uploadStudent(new Student(studentDTO.getId(), studentDTO.getName(),
                studentDTO.getLastname(), studentDTO.getDni()));
    }
}
