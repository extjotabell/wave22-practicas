package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import com.mercadolibre.starwars.util.TestUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FindServiceTest {

    @Mock
    CharacterRepositoryImpl characterRepository;
    @InjectMocks
    FindService findService;


    @Test
    void find() {
        //ARRANGE
        List<CharacterDTO> listExpected = new ArrayList<>();
        List<CharacterDTO> listActual = new ArrayList<>();

        listExpected.add(TestUtil.generateCharacter());

        when(findService.find("luke")).thenReturn(listExpected);

        //ACT
        listActual = findService.find("luke");


        //ASSERT
        assertEquals(listExpected.size(),findService.find("luke").size());
        for (int i = 0; i < listExpected.size(); i++) {
            assertEquals(listExpected.get(i).getName(),listActual.get(i).getName());
            assertEquals(listExpected.get(i).getMass(),listActual.get(i).getMass());
            assertEquals(listExpected.get(i).getHeight(),listActual.get(i).getHeight());
            assertEquals(listExpected.get(i).getGender(),listActual.get(i).getGender());
            assertEquals(listExpected.get(i).getSpecies(),listActual.get(i).getSpecies());
            assertEquals(listExpected.get(i).getHomeworld(),listActual.get(i).getHomeworld());
            assertEquals(listExpected.get(i).getEye_color(),listActual.get(i).getEye_color());
            assertEquals(listExpected.get(i).getBirth_year(),listActual.get(i).getBirth_year());
            assertEquals(listExpected.get(i).getHair_color(),listActual.get(i).getHair_color());
            assertEquals(listExpected.get(i).getSkin_color(),listActual.get(i).getSkin_color());
        }

    }
}