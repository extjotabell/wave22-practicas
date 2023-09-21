package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class FindServiceTest {

    @Mock
    CharacterRepositoryImpl characterRepository = new CharacterRepositoryImpl();

    @InjectMocks
    FindService findService = new FindService();

    @Test
    void findTest(){
        //Arrange
        List<CharacterDTO> expected = new ArrayList<>();
        CharacterDTO characterDTO = new CharacterDTO();
        characterDTO.setName("Luke Skywalker");
        characterDTO.setHeight(172);
        characterDTO.setMass(77);
        characterDTO.setHair_color("blond");
        characterDTO.setSkin_color("fair");
        characterDTO.setEye_color("blue");
        characterDTO.setBirth_year("19BBY");
        characterDTO.setGender("male");
        characterDTO.setHomeworld("Tatooine");
        characterDTO.setSpecies("Human");

        expected.add(characterDTO);

        String param = "Luke";

        List<CharacterDTO> characterDTOList = new ArrayList<>();
        characterDTOList.add(characterDTO);

        //ACT

        Mockito.when(characterRepository.findAllByNameContains(param)).thenReturn(characterDTOList);
        List<CharacterDTO> obtained = findService.find(param);


        //ASSERT

        Assertions.assertEquals(expected,obtained);


    }


}
