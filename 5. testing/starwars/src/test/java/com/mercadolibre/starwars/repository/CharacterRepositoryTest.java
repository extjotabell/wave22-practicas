package com.mercadolibre.starwars.repository;

import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CharacterRepositoryTest {

    @Autowired
    CharacterRepositoryImpl repository;

    @Test
    void findAllByNameTestOk(){
        Assertions.assertFalse(repository.findAllByNameContains("Luke").isEmpty());
    }

    @Test
    void findAllByNameTestNotOk(){
        Assertions.assertTrue(repository.findAllByNameContains("asdasdas").isEmpty());
    }
}
