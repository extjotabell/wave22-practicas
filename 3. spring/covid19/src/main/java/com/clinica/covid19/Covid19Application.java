package com.clinica.covid19;

import com.clinica.covid19.DBMock.DBMock;
import com.clinica.covid19.classes.Sintoma;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Covid19Application {

	public static void main(String[] args) {
		DBMock.sintomas.add(new Sintoma("F", "Fiebre", 2));
		DBMock.sintomas.add(new Sintoma("T", "Tos", 5));

		SpringApplication.run(Covid19Application.class, args);
	}

}
