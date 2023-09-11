package com.sistemaEstudiantes.sistemaEstudiantes.repository;

import com.sistemaEstudiantes.sistemaEstudiantes.model.Student;

import java.util.List;

public interface IStudentRepository {

    List<Student> getAllStudents();
    void uploadStudent(Student student);
}
