package com.mercadolibre.romannumerals.controller;

import com.mercadolibre.romannumerals.RomanNumeralsRestController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ControllerTest {
    // Tests unitarios de controller, según la consigna

    @Autowired
    RomanNumeralsRestController controller;

    @Test
    public void OneOkTest(){
        String roman = controller.toRoman(1);

        Assertions.assertEquals("I", roman);
    }

    @Test
    public void NullOkTest(){
        Assertions.assertThrows(NullPointerException.class, ()->{
            controller.toRoman(null);
        });
    }

    @Test
    public void TwoOkTest(){
        String roman = controller.toRoman(2);

        Assertions.assertEquals("II", roman);
    }

    @Test
    public void ThreeOkTest(){
        String roman = controller.toRoman(3);

        Assertions.assertEquals("III", roman);
    }

    @Test
    public void FourOkTest(){
        String roman = controller.toRoman(4);

        Assertions.assertEquals("IV", roman);
    }

    @Test
    public void FiveOkTest(){
        String roman = controller.toRoman(5);

        Assertions.assertEquals("V", roman);
    }

    @Test
    public void SixOkTest(){
        String roman = controller.toRoman(6);

        Assertions.assertEquals("VI", roman);
    }

    @Test
    public void NineOkTest(){
        String roman = controller.toRoman(9);

        Assertions.assertEquals("IX", roman);
    }

    @Test
    public void TenOkTest(){
        String roman = controller.toRoman(10);

        Assertions.assertEquals("X", roman);
    }

    @Test
    public void NineteenOkTest(){
        String roman = controller.toRoman(19);

        Assertions.assertEquals("XIX", roman);
    }

    @Test
    public void TwentyOneOkTest(){
        String roman = controller.toRoman(21);

        Assertions.assertEquals("XXI", roman);
    }

    @Test
    public void FiftyOkTest(){
        String roman = controller.toRoman(50);

        Assertions.assertEquals("L", roman);
    }

    @Test
    public void HundredOkTest(){
        String roman = controller.toRoman(100);

        Assertions.assertEquals("C", roman);
    }

    @Test
    public void FiveHundredOkTest(){
        String roman = controller.toRoman(500);

        Assertions.assertEquals("D", roman);
    }

    @Test
    public void ThousandOkTest(){
        String roman = controller.toRoman(1000);

        Assertions.assertEquals("M", roman);
    }

}
