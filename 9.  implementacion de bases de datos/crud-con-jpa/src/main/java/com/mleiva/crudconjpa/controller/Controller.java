package com.mleiva.crudconjpa.controller;

import com.mleiva.crudconjpa.model.Student;
import com.mleiva.crudconjpa.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {
    // implemento la interface
    @Autowired
    private IStudentService service;

    // EndPoint para crear un nuevo estudiante.
    @PostMapping("/create")
    public String createStudent(@RequestBody Student student){
        service.saveStudent(student);
        return "El estudiante fue agregado correctamente";
    }
    // EndPoint para traer una lista de todos estudiantes
    @GetMapping("/students")
    public List<Student> getStudents(){
        return service.getStudents();
    }
    // EndPoint para realizar modificaciones a los estudiantes
    @PostMapping("/edit/{id}")
    public Student editStudent(@PathVariable long id,
                              @RequestParam("name") String newName,
                              @RequestParam("lastname") String newLastName){
        Student student = service.findStudent(id);
        //esto puede ir en el service
        student.setLastname(newLastName);
        student.setName(newName);
        service.saveStudent(student);
        return student;
    }
    // EndPoint para eliminar estudiantes.
    @PostMapping("/delete/{id}")
    public String createStudent(@PathVariable long id){
        service.deleStudent(id);
        return "El estudiante fue borrado correctamente";
    }
}
