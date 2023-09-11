package com.starwars.characters;
import com.starwars.characters.entity.MovieCharacter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class CharactersApplication {
	public static List<MovieCharacter> characters = new ArrayList<>();
	public static void main(String[] args) {
		characters.add(new MovieCharacter("Darth Vader",180, 85,
				"Black", "white", "brown", "1950",
				"masculine", "earth", "human"));
		characters.add(new MovieCharacter("Darth Maul",180, 85,
				"Black", "white", "brown", "1950",
				"masculine", "earth", "human"));
		SpringApplication.run(CharactersApplication.class, args);
	}

}
