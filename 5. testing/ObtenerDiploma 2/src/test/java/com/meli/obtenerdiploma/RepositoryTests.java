package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileNotFoundException;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class RepositoryTests {

    @Autowired
    IStudentRepository repo;

    @Test
    void findAllOkTest(){
        int sizeExpected = 3;

        Set<StudentDTO> setOfStudentsDTO = repo.findAll();

        Assertions.assertEquals(sizeExpected, setOfStudentsDTO.size());
    }


}
