package com.mercadolibre.starwars.integrationtest;

import com.mercadolibre.starwars.controller.FindController;
import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;


@SpringBootTest
public class FindControllerIntegrationTest {

    @Autowired
    FindService findService;

    @Test
    void findCharactersByName() throws Exception {
        String query = "Darth";
        ArrayList<CharacterDTO> expectedResult = new ArrayList<>(List.of(
                new CharacterDTO("Darth Vader", "none", "white", "yellow", "41.9BBY", "male", "Tatooine", "Human", 202, 136),
                new CharacterDTO("Darth Maul", "none", "red", "yellow", "54BBY", "male", "Dathomir", "Zabrak", 175, 80)
        ));

        List<CharacterDTO> result = findService.find(query);
        Assertions.assertEquals(expectedResult, result);

    }
}
