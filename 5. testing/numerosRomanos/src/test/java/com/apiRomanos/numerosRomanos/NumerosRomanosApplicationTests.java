package com.apiRomanos.numerosRomanos;

import com.apiRomanos.numerosRomanos.controller.Controller;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NumerosRomanosApplicationTests {

	@Autowired
	Controller controller;

	@ParameterizedTest
	@CsvSource({
			"1 , I",
			"3, III",
			"5, V",
			"7, VII",
			"10, X",
			"50, L"
	})
	void convertNumber1Test(int input, String numberExpected) {
		Assertions.assertEquals(numberExpected, controller.convertNumber(input));
	}

}
