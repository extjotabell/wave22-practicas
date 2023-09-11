package com.sistemaEstudiantes.sistemaEstudiantes.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sistemaEstudiantes.sistemaEstudiantes.model.Student;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Repository
public class StudentRepository implements IStudentRepository{

    List<Student> studentDB;

    public StudentRepository() {
        studentDB = loadDataBase();
    }

    @Override
    public List<Student> getAllStudents() {
        return this.studentDB;
    }

    @Override
    public void uploadStudent(Student student) {
        studentDB.add(student);
        System.out.println("New student uploaded to DB:");
        System.out.println(student);
    }

    private List<Student> loadDataBase(){
        File file = null;

        try {
            file = ResourceUtils.getFile("classpath:Students.json");
        }
        catch(FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        TypeReference<List<Student>> typeRef = new TypeReference<>() {};
        List<Student> characters = null;

        try{
            characters = objectMapper.readValue(file, typeRef);
        }
        catch(IOException e){
            e.printStackTrace();
        }
        System.out.println("Database load successfully!");
        return characters;
    }
}
