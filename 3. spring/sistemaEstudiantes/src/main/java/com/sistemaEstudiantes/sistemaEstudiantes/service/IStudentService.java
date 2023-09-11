package com.sistemaEstudiantes.sistemaEstudiantes.service;

import com.sistemaEstudiantes.sistemaEstudiantes.dto.StudentDTO;
import com.sistemaEstudiantes.sistemaEstudiantes.model.Student;

import java.util.List;

public interface IStudentService {
    List<StudentDTO> getAllStudents();
    void uploadStudent(StudentDTO studentDTO);
}
