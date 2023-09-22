package com.mercadolibre.romannumerals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RomanNumeralsControllerTest {

    @Autowired
    RomanNumeralsRestController romanNumeralsRestController;

    @Test
    void ToRoman1Ok(){
        //ARRANGE
        validToRoman(1,"I");
    }
    @Test
    void ToRoman3Ok(){
        //ARRANGE
        validToRoman(3,"III");
    }

    @Test
    void ToRoman5Ok(){
        //ARRANGE
        validToRoman(5,"V");
    }
    @Test
    void ToRoman7Ok(){
        //ARRANGE
        validToRoman(7,"VII");
    }

    @Test
    void ToRoman10Ok(){
        //ARRANGE
        validToRoman(10,"X");
    }

    @Test
    void ToRoman50Ok(){
        //ARRANGE
        validToRoman(50,"L");
    }
    private void validToRoman(int param, String expected){
        //ACT
        String current = romanNumeralsRestController.toRoman(param);
        //ASSERT
        Assertions.assertEquals(expected,current);
    }
}
