package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class StudentDAOTest {

    @Autowired
    StudentDAO repo;

    @Test
    void existTest(){
        StudentDTO studentDTO = new StudentDTO(1L,"Juan", null,null,
                List.of(new SubjectDTO("Matemática",9.0),
                        new SubjectDTO("Física",7.0),
                        new SubjectDTO("Química",6.0)));

        StudentDTO actual = repo.findById(studentDTO.getId());
        assertEquals(studentDTO,actual);
    }
    @Test
    void existErrorTest(){

        Assertions.assertThrows(StudentNotFoundException.class,()->repo.findById(4L));
    }
}
