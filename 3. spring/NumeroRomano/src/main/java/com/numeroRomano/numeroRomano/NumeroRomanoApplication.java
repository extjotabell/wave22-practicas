package com.numeroRomano.numeroRomano;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NumeroRomanoApplication {

	public static void main(String[] args) {

		System.setProperty("server.port", "8081");
		SpringApplication.run(NumeroRomanoApplication.class, args);
	}

}
