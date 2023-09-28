package com.example.Validaciones.service;

import com.example.Validaciones.dto.request.StudentDTO;
import com.example.Validaciones.dto.response.StudentResponseDTO;

public interface IStudentService {
    StudentDTO save(StudentDTO student);
    String delete(int id);
    StudentResponseDTO getStudentByID(int id);

}
