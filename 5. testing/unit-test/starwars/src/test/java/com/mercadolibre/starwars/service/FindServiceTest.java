package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.utils.ObjectFactoryHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class FindServiceTest {
    @Mock
    CharacterRepository characterRepository;
    @InjectMocks
    FindService findService;
    @Test
    void find_test(){
        Mockito.when(characterRepository.findAllByNameContains(Mockito.anyString()))
                .thenReturn(ObjectFactoryHelper.createSampleCharacterList());
        List<CharacterDTO> result = findService.find("Luke");
        Assertions.assertNotNull(result);
    }
}
