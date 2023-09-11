package com.gym.deportistas;

import com.gym.deportistas.controllers.Sports;
import com.gym.deportistas.models.Level;
import com.gym.deportistas.models.Sport;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DeportistasApplication {
	public static List<Sport> sports = new ArrayList<>();
	public static void main(String[] args) {
		sports.add(new Sport("Futbol", Level.BASIC));
		sports.add(new Sport("Voley", Level.INTERMEDIATE));
		SpringApplication.run(DeportistasApplication.class, args);
	}

}
