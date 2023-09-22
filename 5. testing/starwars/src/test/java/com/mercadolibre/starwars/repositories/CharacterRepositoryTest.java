package com.mercadolibre.starwars.repositories;

import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class CharacterRepositoryTest {

    @Autowired
    CharacterRepositoryImpl characterRepository;

    @Test
    void findAllByNameContains(){
        //Arrange
        String query = "Luke Skywalker";
        CharacterDTO lukeSkywalker = new CharacterDTO("Luke Skywalker","blond", "fair","blue","19BBY", "male","Tatooine", "Human", 172, 77);
        //Act
        List<CharacterDTO> characterDTOList = characterRepository.findAllByNameContains(query);
        //Assert
        Assertions.assertEquals(lukeSkywalker,characterDTOList.get(0));
    }

    @Test
    void findNoneByNameContains(){
        //Arrange
        String query = "Gaspar";
        int expectedSize = 0;
        //Act
        List<CharacterDTO> characterDTOList = characterRepository.findAllByNameContains(query);
        //Assert
        Assertions.assertEquals(expectedSize,characterDTOList.size());
    }
}
