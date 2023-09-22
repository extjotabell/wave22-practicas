package com.mercadolibre.romannumerals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class RomanNumeralsRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @ParameterizedTest
    @CsvSource({
            "1, I",
            "3, III",
            "5, V",
            "7, VII",
            "10, X",
            "50, L"
    })
    void toRoman(String number, String romanNumeral) throws Exception {

        mockMvc.perform(get("/{number}", number))
                .andExpect(status().isOk())
                .andExpect(content().string(romanNumeral))
                .andDo(print());
    }

}