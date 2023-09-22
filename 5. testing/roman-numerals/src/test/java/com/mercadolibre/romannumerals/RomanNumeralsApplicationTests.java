package com.mercadolibre.romannumerals;

import org.junit.jupiter.api.Assertions;
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

  @Autowired
  RomanNumeralsRestController controller;

  @Test
  void oneShouldBeI() throws Exception {
    performTest("1", "I");
  }

  @Test
  void tenShouldBeX() throws Exception {
    performTest("10", "X");
  }

  @Test
  void sevenShouldBeVII() throws Exception {
    performTest("7", "VII");
  }

  @Test
  void fifteenShouldBeXV() throws Exception {
    performTest("15", "XV");
  }

  private void performTest(String decimal, String roman) throws Exception {
    this.mockMvc.perform(get("/" + decimal))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string(containsString(roman)));
  }


  private void toRomanOk(String decimal, String roman){
    //ACT
    String actual = controller.toRoman(Integer.parseInt(decimal));
    //ASSERTION
    Assertions.assertEquals(roman,actual);

  }

  @Test
  void OneOK(){
    toRomanOk("1","I");
  }

  @Test
  void ThreeOK(){
    toRomanOk("3","III");
  }

  @Test
  void FiveOK(){
    toRomanOk("5","V");
  }

  @Test
  void SevenOK(){
    toRomanOk("7","VII");
  }

  @Test
  void TenOK(){
    toRomanOk("10","X");
  }

  @Test
  void FiftyOK(){
    toRomanOk("50","L");
  }
}
