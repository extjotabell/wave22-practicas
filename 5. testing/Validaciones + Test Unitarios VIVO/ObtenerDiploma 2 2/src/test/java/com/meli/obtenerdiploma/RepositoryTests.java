package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

@SpringBootTest
class RepositoryTests {

    @Autowired
    IStudentRepository repo;

    @Test
    void findAllOkTest(){
        int sizeExpected = 2;

        Set<StudentDTO> setOfStudentsDTO = repo.findAll();

        Assertions.assertEquals(sizeExpected, setOfStudentsDTO.size());
    }

}
