package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class StudentDAOTest {
    @Autowired
    StudentDAO studentDAO;

    @Test
    void findByIdOKTest(){
        //Arrange
        Long param = 1L;
        StudentDTO devolution = new StudentDTO();
        devolution.setId(param);
        studentDAO.save(devolution);

        //Act
        StudentDTO obtain = studentDAO.findById(devolution.getId());

        //Assert
        Assertions.assertEquals(devolution, obtain);
    }

    @Test
    void findByIdNotFoundTest(){
        //Arrange
        Long param = 1L;
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(param);
        studentDAO.delete(studentDTO.getId());

        //Act & Assert
        Assertions.assertThrows(StudentNotFoundException.class,()-> studentDAO.findById(param));
    }

    @Test
    void existsOkTest(){
        //Arrange
        boolean devolution = true;
        StudentDTO param = new StudentDTO();
        param.setId(1L);
        studentDAO.save(param);

        //Act
        boolean obtain = studentDAO.exists(param);

        //Assert
        Assertions.assertEquals(devolution, obtain);
    }

    @Test
    void existsFailTest(){
        //Arrange
        boolean devolution = false;
        StudentDTO param = new StudentDTO();
        param.setId(1L);
        studentDAO.delete(param.getId());

        //Act
        boolean obtain = studentDAO.exists(param);

        //Assert
        Assertions.assertEquals(devolution,obtain);
    }

    @Test
    void deleteOKTest(){
        //Arrange
        boolean devolution = true;
        StudentDTO param = new StudentDTO();
        param.setId(1L);
        studentDAO.save(param);

        //Act
        boolean obtain = studentDAO.delete(param.getId());

        //Assert
        Assertions.assertEquals(devolution, obtain);
    }


    @Test
    void deleteFailTest(){
        //Arrange
        boolean devolution = false;
        StudentDTO param = new StudentDTO();
        param.setId(1L);
        studentDAO.delete(param.getId());

        //Act
        boolean obtain = studentDAO.delete(param.getId());

        //Assert
        Assertions.assertEquals(devolution,obtain);
    }
}
