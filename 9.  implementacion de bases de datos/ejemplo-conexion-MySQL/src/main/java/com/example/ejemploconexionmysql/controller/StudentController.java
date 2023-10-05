package com.example.ejemploconexionmysql.controller;

import com.example.ejemploconexionmysql.dto.StudentDTO;
import com.example.ejemploconexionmysql.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<?> getAll (){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getAll());
    }

    @PostMapping
    public  ResponseEntity<?> save(@RequestBody StudentDTO studentDTO){

        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.save(studentDTO));
    }
}
