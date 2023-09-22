package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FindServiceTest {

    @Mock
    CharacterRepository repository;
    @InjectMocks
    FindService service;

    @Test
    void findServiceOk(){
        // ARRANGE
        String param = "Luke";
        List<CharacterDTO> expected = new ArrayList<>();
        expected.add(new CharacterDTO("Luke SkyWalker", null,null,null,null,null,null,null,null,null));
        when(repository.findAllByNameContains(param)).thenReturn(expected);
        // ACT
        List<CharacterDTO> obtained = service.find(param);
        // ASSERT
        assertEquals(expected,obtained);
    }

    @Test
    void findServiceNotOk(){
        // ARRANGE
        String param = "XXX";
        List<CharacterDTO> expected = new ArrayList<>();
        when(repository.findAllByNameContains(param)).thenReturn(expected);

        // ACT
        List<CharacterDTO> obtained = service.find(param);
        // ASSERT
        assertEquals(expected,obtained);

    }
}
