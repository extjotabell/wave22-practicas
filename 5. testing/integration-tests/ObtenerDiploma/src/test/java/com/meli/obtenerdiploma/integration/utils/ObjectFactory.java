package com.meli.obtenerdiploma.integration.utils;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ObjectFactory {
    private List<SubjectDTO> subjects = new ArrayList<>();
    private List<String> names = List.of("Math", "Science", "History", "English", "Art", "Music", "Physical Education", "Computer Science", "Biology", "Geography");

    public ObjectFactory() {
        for (int i = 0; i < 10; i++) {
            Random random = new Random();
            SubjectDTO subjectDTO = new SubjectDTO();
            subjectDTO.setName(names.get(i));
            subjectDTO.setScore(Math.floor(1.0 + (10.0 - 1.0) * random.nextDouble()));
            subjects.add(subjectDTO);
        }
    }

    public SubjectDTO getSubjectDTO(int index) {
        return subjects.get(index);
    }

    public StudentDTO studentDTOProvider() {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudentName("Name");
        studentDTO.setId(1L);
        studentDTO.setMessage("message");
        studentDTO.setSubjects(subjects);
        studentDTO.setAverageScore(10.9);
        return studentDTO;
    }
}
