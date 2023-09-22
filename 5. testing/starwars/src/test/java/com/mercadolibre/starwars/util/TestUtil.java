package com.mercadolibre.starwars.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.mercadolibre.starwars.dto.CharacterDTO;
import org.springframework.util.ResourceUtils;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class TestUtil {

    private static ObjectWriter writer;

    public static CharacterDTO getCharacterDTO() {
        return new CharacterDTO("C-3PO", "NA", "gold", "yellow", "112BBY", "NA", "Tatooine", "Droid", 167, 75);
    }

    public static List<CharacterDTO> getAllCharactersDTO() {
        CharacterDTO luke = new CharacterDTO("Luke Skywalker", "blond", "fair", "blue", "19BBY", "male", "Tatooine", "Human", 172, 77);
        CharacterDTO darthVader = new CharacterDTO("Darth Vader", "none", "white", "yellow", "41.9BBY", "male", "Tatooine", "Human", 202, 136);
        CharacterDTO darthMaul = new CharacterDTO("Darth Maul", "none", "red", "yellow", "54BBY", "male", "Dathomir", "Zabrak", 175, 80);

        return new ArrayList<>(List.of(luke, darthVader, darthMaul));
    }

    public static void emptyCharactersFile() {
        PrintWriter writer = null;

        try {
            writer = new PrintWriter(ResourceUtils.getFile("./src/test/resources/starwars_characters.json"));
        } catch (
                IOException e) {
            e.printStackTrace();
        }

        writer.print("[]");
        writer.close();
    }

    public static void charactersFile() {
        PrintWriter writer = null;

        try {
            writer = new PrintWriter(ResourceUtils.getFile("./src/test/resources/starwars_characters.json"));
        } catch (
                IOException e) {
            e.printStackTrace();
        }

        writer.print("[\n" +
                "  {\n" +
                "    \"name\": \"Luke Skywalker\",\n" +
                "    \"height\": 172,\n" +
                "    \"mass\": 77,\n" +
                "    \"hair_color\": \"blond\",\n" +
                "    \"skin_color\": \"fair\",\n" +
                "    \"eye_color\": \"blue\",\n" +
                "    \"birth_year\": \"19BBY\",\n" +
                "    \"gender\": \"male\",\n" +
                "    \"homeworld\": \"Tatooine\",\n" +
                "    \"species\": \"Human\"\n" +
                "  },\n" +
                "{\n" +
                "    \"name\": \"Darth Vader\",\n" +
                "    \"height\": 202,\n" +
                "    \"mass\": 136,\n" +
                "    \"hair_color\": \"none\",\n" +
                "    \"skin_color\": \"white\",\n" +
                "    \"eye_color\": \"yellow\",\n" +
                "    \"birth_year\": \"41.9BBY\",\n" +
                "    \"gender\": \"male\",\n" +
                "    \"homeworld\": \"Tatooine\",\n" +
                "    \"species\": \"Human\"\n" +
                "  },\n" +
                "{\n" +
                "    \"name\": \"Darth Maul\",\n" +
                "    \"height\": 175,\n" +
                "    \"mass\": 80,\n" +
                "    \"hair_color\": \"none\",\n" +
                "    \"skin_color\": \"red\",\n" +
                "    \"eye_color\": \"yellow\",\n" +
                "    \"birth_year\": \"54BBY\",\n" +
                "    \"gender\": \"male\",\n" +
                "    \"homeworld\": \"Dathomir\",\n" +
                "    \"species\": \"Zabrak\"\n" +
                "  }\n" +
                "]");
        writer.close();
    }

    public static String stringify(Object obj) throws JsonProcessingException {
        writer = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                //.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"))
                .writer();
        return writer.writeValueAsString(obj);
    }
}
