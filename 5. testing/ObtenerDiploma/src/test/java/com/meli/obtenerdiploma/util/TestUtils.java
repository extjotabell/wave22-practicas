package com.meli.obtenerdiploma.util;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;

import java.util.ArrayList;
import java.util.List;

public class TestUtils {

    public static StudentDTO getMockStudent(String name) {

        List<SubjectDTO> subjects = new ArrayList<>();
        SubjectDTO s1 = new SubjectDTO("Lengua", 5.0);
        SubjectDTO s2 = new SubjectDTO("Matematica", 5.0);
        SubjectDTO s3 = new SubjectDTO("Historia", 8.0);
        subjects.add(s1);
        subjects.add(s2);
        subjects.add(s3);

        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(1L);
        studentDTO.setMessage("El alumno " + name + " ha obtenido un promedio de 6. Puedes mejorar.");
        studentDTO.setStudentName(name);
        studentDTO.setAverageScore(6.0);
        studentDTO.setSubjects(subjects);

        return studentDTO;

    }

    public static StudentDTO getMockStudentAdd(String name) {

        List<SubjectDTO> subjects = new ArrayList<>();
        SubjectDTO s1 = new SubjectDTO("Lengua", 5.0);
        SubjectDTO s2 = new SubjectDTO("Matematica", 5.0);
        SubjectDTO s3 = new SubjectDTO("Historia", 8.0);
        subjects.add(s1);
        subjects.add(s2);
        subjects.add(s3);

        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(100L);
        //studentDTO.setMessage("El alumno " + name + " ha obtenido un promedio de 6. Puedes mejorar.");
        studentDTO.setStudentName(name);
        //studentDTO.setAverageScore(6.0);
        studentDTO.setSubjects(subjects);

        return studentDTO;

    }

    public static StudentDTO getMockStudentModify(String name) {

        List<SubjectDTO> subjects = new ArrayList<>();
        SubjectDTO s1 = new SubjectDTO("Lengua", 5.0);
        SubjectDTO s2 = new SubjectDTO("Matematica", 5.0);
        SubjectDTO s3 = new SubjectDTO("Historia", 8.0);
        subjects.add(s1);
        subjects.add(s2);
        subjects.add(s3);

        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(200L);
        //studentDTO.setMessage("El alumno " + name + " ha obtenido un promedio de 6. Puedes mejorar.");
        studentDTO.setStudentName(name);
        //studentDTO.setAverageScore(6.0);
        studentDTO.setSubjects(subjects);

        return studentDTO;

    }
}
