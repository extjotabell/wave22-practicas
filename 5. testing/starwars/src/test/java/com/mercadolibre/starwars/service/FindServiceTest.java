package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class FindServiceTest {

    @Mock
    CharacterRepositoryImpl repository;

    @InjectMocks
    FindService service;

    @Test
    void findTestOk(){
        List<CharacterDTO> characterDTOList = new ArrayList<>();
        characterDTOList.add(new CharacterDTO("Luke Skywalker", "blond", "fair", "blue", "19BBY", "male", "Tatooine", "Human", 172, 77));
        Mockito.when(repository.findAllByNameContains("Luke Sky")).thenReturn(characterDTOList);

        Assertions.assertEquals(characterDTOList, service.find("Luke Sky"));
    }

    @Test
    void findTestEmpty(){
        Mockito.when(repository.findAllByNameContains("asdasdas")).thenReturn(List.of());

        Assertions.assertTrue(service.find("asdasdas").isEmpty());
    }
}
