package com.mercadolibre.starwars.repositories;

import com.mercadolibre.starwars.CharacterRepositoryImpl;
import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class CharacterRepositoryTest {

    @Autowired
    CharacterRepositoryImpl characterRepository;

    @Test
    void findAllByNameCointainsOkTest(){
        //Assert
        String param = "Luke";
        List<CharacterDTO> devolution = new ArrayList<>();
        devolution.add(new CharacterDTO("Luke Skywalker","blond","fair","blue","19BBY","male","Tatooine","Human",172,77));

        //Act
        List<CharacterDTO> obtain = characterRepository.findAllByNameContains(param);

        //Assert
        Assertions.assertEquals(devolution,obtain);


    }


    @Test
    void findAllByNameCointainsNoMatchTest(){
        //Assert
        String param = "LukeAsdascasdasdasdasda";
        List<CharacterDTO> devolution = new ArrayList<>();

        //Act
        List<CharacterDTO> obtain = characterRepository.findAllByNameContains(param);

        //Assert
        Assertions.assertEquals(devolution,obtain);


    }

}
