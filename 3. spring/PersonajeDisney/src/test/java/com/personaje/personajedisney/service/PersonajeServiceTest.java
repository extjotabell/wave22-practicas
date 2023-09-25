package com.personaje.personajedisney.service;

import com.personaje.personajedisney.Interface.IPersonajeRepository;
import com.personaje.personajedisney.Service.PersonajeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PersonajeServiceTest {

    @Mock
    IPersonajeRepository repo;

    @InjectMocks
    PersonajeService service;

    @Test

}
