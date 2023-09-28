package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentDAOTest {
     Set<StudentDTO> students = new HashSet<>();
     StudentDAO studentDAO;

    @BeforeEach
     void setup(){
        System.out.println("Ejecutando...");
        studentDAO = new StudentDAO();
        StudentDTO s1 = new StudentDTO(1l, "Maria", "message", 10.0, List.of(new SubjectDTO("Ciencia", 10.0)));
        StudentDTO s2 = new StudentDTO(2l, "Carla", "message", 10.0, List.of(new SubjectDTO("Ciencia", 10.0)));
        StudentDTO s3 = new StudentDTO(3l, "Ana", "message", 10.0, List.of(new SubjectDTO("Ciencia", 10.0)));
        StudentDTO s4 = new StudentDTO(4l, "Juan", "message", 10.0, List.of(new SubjectDTO("Ciencia", 10.0)));
        StudentDTO s5 = new StudentDTO(5l, "Pepe", "message", 10.0, List.of(new SubjectDTO("Ciencia", 10.0)));
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
        students.add(s5);
        studentDAO.setStudents(students);
    }

    // Casos felices:

    @Test
    void save_test(){
        //arrange
        StudentDTO s6 = new StudentDTO(6l, "Noe", "message", 10.0, List.of(new SubjectDTO("Ciencia", 10.0)));
        // act
        studentDAO.save(s6);
        // assert
        assertTrue(students.contains(s6));
    }

    @Test
    void delete_test(){
        //arrange
        StudentDTO s7 = new StudentDTO(7l, "Gabriel", "message", 10.0, List.of(new SubjectDTO("Ciencia", 10.0)));
        // act
        studentDAO.save(s7);
        // act
        boolean deletedStudent = studentDAO.delete(s7.getId());
        //assert
        assertFalse(students.contains(s7));
    }

    @Test
    void exists_test(){
        StudentDTO s8 = new StudentDTO(8l, "Martha", "message", 10.0, List.of(new SubjectDTO("Ciencia", 10.0)));
        studentDAO.save(s8);
        boolean existingStudent = studentDAO.exists(s8);
        assertTrue(existingStudent);
    }

    @Test
    void findById_test(){
        StudentDTO s9 = new StudentDTO(9l, "Jorge", "message", 10.0, List.of(new SubjectDTO("Ciencia", 10.0)));
        studentDAO.save(s9);
        StudentDTO found = studentDAO.findById(s9.getId());
        assertEquals(s9.getId(), found.getId());
    }

    @Test
    void should_updateStudentData_test(){
        StudentDTO student = studentDAO.findById(2L);
        student.setStudentName("Modified");
        studentDAO.save(student);
        //assert
        assertEquals("Modified", student.getStudentName());
    }

    // Errores y excepciones

    @Test
    void should_throwStudentNotFoundException_when_userNotExist(){
        StudentDTO s10 = new StudentDTO(10L, "Victor", "message", 10.0, List.of(new SubjectDTO("Ciencia", 10.0)));

        Executable executable = () -> studentDAO.exists(s10);
        assertThrows(StudentNotFoundException.class, executable);
    }
    @Test
    void should_throwStudentNotFoundException_when_findById(){
        Executable executable = () -> studentDAO.findById(20L);
        assertThrows(StudentNotFoundException.class, executable);
    }

}
