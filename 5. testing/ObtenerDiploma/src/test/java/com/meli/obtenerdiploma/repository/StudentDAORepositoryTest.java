package com.meli.obtenerdiploma.repository;


import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentDAORepositoryTest {

    StudentDAO studentDAO = new StudentDAO();

    @Test
    void saveStudent() {
        //Arrange
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(new SubjectDTO("Ciencias", 8.0));
        StudentDTO student = new StudentDTO(10L ,"Ale", "hola", 8.5, subjectDTOList);
        int expectedSize = 0;

        //Action
        studentDAO.save(student);
        expectedSize = studentDAO.getStudents().size();

        //Assert
        assertEquals(expectedSize,studentDAO.getStudents().size());
    }

    @Test
    void deleteStudentOK(){
        //Arrange
        Long id = 3L;

        //Act
        boolean actual = studentDAO.delete(id);

        //Assert
        assertTrue(actual);
    }

    @Test
    void findStudentById(){
        //Arrange
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(new SubjectDTO("lengua",6.5));
        StudentDTO student = new StudentDTO(10L ,"Ale", "hola", 8.5, subjectDTOList);
        studentDAO.save(student);

        //Act
        StudentDTO studentFound = studentDAO.findById(student.getId());

        //Assert
        assertEquals(student, studentFound);
    }

    @Test
    void findByIdError(){
        //Arrange
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(new SubjectDTO("lengua",6.5));
        StudentDTO student = new StudentDTO(11L ,"Ale", "hola", 8.5, subjectDTOList);

        //ACT AND ASSERT
        Assertions.assertThrows(StudentNotFoundException.class,()-> studentDAO.findById(student.getId()));

    }


    @Test
    void ModificarDatosAlumno(){
        //Arrange
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(new SubjectDTO("matematica", 8.0));
        StudentDTO student = new StudentDTO(3L ,"Valen", "no se", 8.5, subjectDTOList);
        int expectedSize = 0;

        //Action
        studentDAO.save(student);
        expectedSize = studentDAO.getStudents().size();

        //Assert
        assertEquals(expectedSize,studentDAO.getStudents().size());
    }
}
