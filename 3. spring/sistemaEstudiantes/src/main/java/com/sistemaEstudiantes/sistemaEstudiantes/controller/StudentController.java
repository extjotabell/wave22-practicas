package com.sistemaEstudiantes.sistemaEstudiantes.controller;

import com.sistemaEstudiantes.sistemaEstudiantes.dto.StudentDTO;
import com.sistemaEstudiantes.sistemaEstudiantes.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    IStudentService service;

    @GetMapping("/students")
    public ResponseEntity<?> getAllStudents(){
        List<StudentDTO> studentsDTOList = service.getAllStudents();
        return new ResponseEntity<>(studentsDTOList, HttpStatus.OK);
    }

    @PostMapping("/uploadStudent")
    public ResponseEntity<?>uploadStudent(@RequestBody StudentDTO studentDTO){
        service.uploadStudent(studentDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
