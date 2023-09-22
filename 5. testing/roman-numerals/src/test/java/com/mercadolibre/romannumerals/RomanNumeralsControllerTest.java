package com.mercadolibre.romannumerals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RomanNumeralsControllerTest {

    RomanNumeralsRestController controller = new RomanNumeralsRestController();

    @Test
    void toRoman(){
        //Arrange
        Integer decimal = 1994;
        String roman = "MCMXCIV";

        //Act
        String result = controller.toRoman(decimal);

        //Assert
        Assertions.assertEquals(roman, result);

    }

}
