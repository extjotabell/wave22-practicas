package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Set;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    IStudentService studentService;

    @PostMapping("/registerStudent")
    public ResponseEntity<Object> registerStudent(@RequestBody @Valid StudentDTO stu) {
        this.studentService.create(stu);
        return ResponseEntity.ok(null);
    }

    @GetMapping("/getStudent/{id}")
    public StudentDTO getStudent(@PathVariable Long id) {
        return this.studentService.read(id);
    }

    @PostMapping("/modifyStudent")
    public ResponseEntity<Object> modifyStudent(@RequestBody @Valid StudentDTO stu) {
        this.studentService.update(stu);
        return ResponseEntity.ok(null);
    }

    @GetMapping("/removeStudent/{id}")
    public ResponseEntity<Object> removeStudent(@PathVariable Long id) {
        this.studentService.delete(id);
        return ResponseEntity.ok(null);
    }

    @GetMapping("/listStudents")
    public Set<StudentDTO> listStudents() throws IOException {
        return this.studentService.getAll();
    }

}
