package com.mercadolibre.starwars.repositories;

import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.*;

import java.util.List;

public class CharacterRepositoryImplTest {

    CharacterRepositoryImpl characterRepository;

    @Test
    public void findAllByNameContains() {
        //Arrange
        String query = "Luke";

        //Act
        List<CharacterDTO> characterDTOList = characterRepository.findAllByNameContains(query);

        //Assert
        Assertions.assertEquals(query,characterDTOList.get(1).getName());
        //Assertions.assertFalse(characterDTOList.isEmpty());
    }
}
