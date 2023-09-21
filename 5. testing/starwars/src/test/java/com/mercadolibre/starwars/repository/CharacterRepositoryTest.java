package com.mercadolibre.starwars.repository;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


public class CharacterRepositoryTest {

    CharacterRepository repository = new CharacterRepositoryImpl();

    @Test
    void findAllByNameContains(){
        //Arrange
        List<CharacterDTO> characterList = new ArrayList<>();
        CharacterDTO expected = new CharacterDTO("Luke Skywalker", "blond", "fair","blue", "19BBY", "male", "Tatooine", "Human", 172, 77);
        characterList.add(expected);

        String query = "Luke";

        //Act
        List<CharacterDTO> result = repository.findAllByNameContains("Luke Skywalker");


        //Assert
        Assertions.assertEquals(result, characterList);
    }

}
