package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class FindControllerTest {

    @Mock
    private FindService findService;

    @InjectMocks
    private FindController findController;

    @Test
    void find() {

        findController.find("some");
        Mockito.verify(findService, Mockito.atLeastOnce()).find("some");
    }
}