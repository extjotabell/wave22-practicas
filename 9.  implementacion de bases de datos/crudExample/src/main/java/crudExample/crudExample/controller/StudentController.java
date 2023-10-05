package crudExample.crudExample.controller;

import crudExample.crudExample.dto.MessageDto;
import crudExample.crudExample.model.Student;
import crudExample.crudExample.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    IStudentService service;

    @PostMapping("/create")
    public ResponseEntity<MessageDto> createStudent(@RequestBody Student student){
        service.saveStudent(student);
        return new ResponseEntity<>(new MessageDto("El estudiante fue creado correctamente"), HttpStatus.OK);
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getStudents(){
        return new ResponseEntity<>(service.getStudents(), HttpStatus.OK);
    }

    @PostMapping("edit/{id}")
    public ResponseEntity<Student> editStudent(@PathVariable long id,
                                         @RequestParam String newName,
                                         @RequestParam String newLastName){
        return new ResponseEntity<>(service.updateStudent(id, newName, newLastName), HttpStatus.OK);
    }

    @PostMapping("delete/{id}")
    public ResponseEntity<MessageDto> deleteStudent(@PathVariable long id){
        service.deleteStudent(id);
        return new ResponseEntity<>(new MessageDto("El estudiante fue borrado correctamente"), HttpStatus.OK);
    }
}
