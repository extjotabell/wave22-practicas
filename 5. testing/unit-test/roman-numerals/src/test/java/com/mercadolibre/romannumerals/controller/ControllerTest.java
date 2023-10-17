package com.mercadolibre.romannumerals.controller;

import com.mercadolibre.romannumerals.RomanNumeralsRestController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
 class ControllerTest {
    @Autowired
    RomanNumeralsRestController romanNumeralsRestController;
    @Test
     void testToRoman_1_ReturnsI() {
        int number = 1;
        String expectedRoman = "I";
        String actualRoman = romanNumeralsRestController.toRoman(number);
        assertEquals(expectedRoman, actualRoman);
    }

    @Test
     void testToRoman_3_ReturnsIII() {
        int number = 3;
        String expectedRoman = "III";
        String actualRoman = romanNumeralsRestController.toRoman(number);
        assertEquals(expectedRoman, actualRoman);
    }

    @Test
     void testToRoman_5_ReturnsV() {
        int number = 5;
        String expectedRoman = "V";
        String actualRoman = romanNumeralsRestController.toRoman(number);
        assertEquals(expectedRoman, actualRoman);
    }

    @Test
     void testToRoman_7_ReturnsVII() {
        int number = 7;
        String expectedRoman = "VII";
        String actualRoman = romanNumeralsRestController.toRoman(number);
        assertEquals(expectedRoman, actualRoman);
    }

    @Test
     void testToRoman_10_ReturnsX() {
        int number = 10;
        String expectedRoman = "X";
        String actualRoman = romanNumeralsRestController.toRoman(number);
        assertEquals(expectedRoman, actualRoman);
    }

    @Test
     void testToRoman_50_ReturnsL() {
        int number = 50;
        String expectedRoman = "L";
        String actualRoman = romanNumeralsRestController.toRoman(number);
        assertEquals(expectedRoman, actualRoman);
    }
}
