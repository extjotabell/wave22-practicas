package com.mercadolibre.starwars.repository;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;


public class CharacterRepositoryImplTest {

    CharacterRepository repo;
    @BeforeEach
    private void setUp() {
        this.repo = new CharacterRepositoryImpl();
    }
    @Test
    void findAllByNameContainsTest(){
        List<CharacterDTO> characterDTOS = new ArrayList<>(List.of(
                new CharacterDTO(    "Darth Vader","none","white","yellow","41.9BBY","male", "Tatooine","Human",202,136),
                new CharacterDTO(    "Darth Maul","none","red","yellow","54BBY","male", "Dathomir","Zabrak",175,80)
        ));
        String query = "Darth";

        List<CharacterDTO> characterlist =repo.findAllByNameContains(query);
        Assertions.assertEquals(characterDTOS,characterlist);

    }
}
