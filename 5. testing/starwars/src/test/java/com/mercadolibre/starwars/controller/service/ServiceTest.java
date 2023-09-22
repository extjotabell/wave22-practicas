package com.mercadolibre.starwars.controller.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import com.mercadolibre.starwars.service.FindService;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ServiceTest {

    @Autowired
    FindService service;

    @Autowired
    CharacterRepositoryImpl repo;

    @Test
    void findOk(){
        String query = "Luke";
        List<CharacterDTO> expected = List.of(new CharacterDTO("Luke Skywalker",172,77,"blond","fair","blue","19BBY","male","Tatooine","Human"));

        List<CharacterDTO> actual = service.find(query);

        Assertions.assertTrue(CollectionUtils.isEqualCollection(expected,actual));
    }
}
