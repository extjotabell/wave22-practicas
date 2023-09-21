package com.mercadolibre.starwars.repositories;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CharacterRepositoryTest {
    @Autowired
    CharacterRepository characterRepository;

    @Test
    void findAllByNameContains() {
        //Arrange
        //Act
        //Assert
        Assertions.assertTrue(!this.characterRepository.findAllByNameContains("Darth").isEmpty());
    }
}