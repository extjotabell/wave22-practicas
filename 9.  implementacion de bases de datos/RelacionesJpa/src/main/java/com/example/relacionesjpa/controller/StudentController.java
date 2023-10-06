package com.example.relacionesjpa.controller;

import com.example.relacionesjpa.dto.ManyToMany.StudentDTO;
import com.example.relacionesjpa.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    @Autowired
    StudentService service;


    @PostMapping("/student/save")
    public ResponseEntity<?> guardar(@RequestBody StudentDTO stu){
        return new ResponseEntity<>(service.guardar(stu), HttpStatus.OK);
    }
}
