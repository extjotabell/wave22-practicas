package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.controller.FindController;
import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class FindControllerTest {
    @Mock
    FindService findService;
    @InjectMocks
    FindController findController;

    @Test
    @DisplayName("find() oK test method")
    void find_test_OK(){
        Mockito.when(findService.find(Mockito.anyString())).thenReturn(Mockito.anyList());
        List<CharacterDTO> result = findController.find("Luke");
        Assertions.assertNotNull(result);
    }
}
