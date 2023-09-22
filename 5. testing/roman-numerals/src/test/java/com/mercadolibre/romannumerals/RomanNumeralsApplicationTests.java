package com.mercadolibre.romannumerals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class RomanNumeralsApplicationTests {
  @Autowired
  private MockMvc mockMvc;

  @Test
  void oneShouldBeI() throws Exception {
    performTest("1", "I");
  }

  @Test
  void threeShouldBeIII() throws Exception {
    performTest("3", "III");
  }

  @Test
  void fourShouldBeIV() throws Exception{
    performTest("4","IV");
  }

  @Test
  void fiveShouldBeV() throws Exception{
    performTest("5","V");
  }

  @Test
  void sevenShouldBeVII() throws Exception {
    performTest("7", "VII");
  }

  @Test
  void nineShouldBeIX() throws Exception {
    performTest("9", "IX");
  }

  @Test
  void tenShouldBeX() throws Exception {
    performTest("10", "X");
  }

  @Test
  void fifteenShouldBeXV() throws Exception {
    performTest("15", "XV");
  }

  @Test
  void fourtyShouldBeXL() throws Exception {
    performTest("40", "XL");
  }

  @Test
  void fiftyShouldBeL() throws Exception {
    performTest("50", "L");
  }

  @Test
  void ninetyShouldBeXC() throws Exception {
    performTest("90", "XC");
  }

  @Test
  void hundredShouldBeC() throws Exception {
    performTest("100", "C");
  }

  @Test
  void fiourHundredShouldBeCD() throws Exception {
    performTest("400", "CD");
  }

  @Test
  void fiveHundredShouldBeD() throws Exception {
    performTest("500", "D");
  }

  @Test
  void nineHundredShouldBeCM() throws Exception {
    performTest("900", "CM");
  }

  @Test
  void thousandShouldBeM() throws Exception {
    performTest("1000", "M");
  }


  private void performTest(String decimal, String roman) throws Exception {
    this.mockMvc.perform(get("/" + decimal))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string(containsString(roman)));
  }
}
