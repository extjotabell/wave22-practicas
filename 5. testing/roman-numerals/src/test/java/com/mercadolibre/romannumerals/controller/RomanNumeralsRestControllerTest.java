package com.mercadolibre.romannumerals.controller;

import com.mercadolibre.romannumerals.RomanNumeralsRestController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RomanNumeralsRestControllerTest {

    RomanNumeralsRestController controller;
    @BeforeEach
    private void setUp() {
        this.controller = new RomanNumeralsRestController();
    }

    @Test
    void toRomanTest(){
        String seven =controller.toRoman(7);
        String fifty = controller.toRoman(50);

        Assertions.assertEquals(seven,"VII");
        Assertions.assertEquals(fifty,"L");

    }
}
