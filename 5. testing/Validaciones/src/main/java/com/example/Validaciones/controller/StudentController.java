package com.example.Validaciones.controller;

import com.example.Validaciones.dto.request.StudentDTO;
import com.example.Validaciones.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    IStudentService studentService;

    @PostMapping()
    public ResponseEntity<?> saveStudent(@RequestBody @Valid StudentDTO studentDTO){
        return new ResponseEntity<>(studentService.save(studentDTO), HttpStatus.OK);
    }
    @PostMapping("/delete/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable int id){
        return new ResponseEntity<>(studentService.delete(id), HttpStatus.OK);
    }
    @GetMapping("student/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable int id){
        return new ResponseEntity<>(studentService.getStudentByID(id), HttpStatus.OK);
    }

}
