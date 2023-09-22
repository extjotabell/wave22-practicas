package com.mercadolibre.starwars.controller.repository;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import com.mercadolibre.starwars.service.FindService;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

//@SpringBootTest
public class RepositoryTest {

   CharacterRepositoryImpl repo = new CharacterRepositoryImpl();



    @Test
    void findAllByNameContainsOk(){
        String query = "Luke";
        List<CharacterDTO> expected = List.of(new CharacterDTO("Luke Skywalker",172,77,"blond","fair","blue","19BBY","male","Tatooine","Human"));

        List<CharacterDTO> actual = repo.findAllByNameContains(query);

        Assertions.assertTrue(CollectionUtils.isEqualCollection(expected,actual));
    }
}
