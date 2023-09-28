package com.example.Validaciones.repo;

import com.example.Validaciones.entity.Student;

public interface IStudentRepo {
    Student save(Student student);
    boolean delete(int id);
    Student findById(int id);
}
