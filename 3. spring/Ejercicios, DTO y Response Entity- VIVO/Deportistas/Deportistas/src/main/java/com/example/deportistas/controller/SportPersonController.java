package com.example.deportistas.controller;

import com.example.deportistas.dto.SportDTO;
import com.example.deportistas.dto.SportPersonDTO;
import com.example.deportistas.model.Person;
import com.example.deportistas.model.Sport;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class SportPersonController {
    private static final List<Sport> sports = new ArrayList<>();
    private static final List<Person> persons = new ArrayList<>();

    public SportPersonController() {
        sports.add(new Sport("taekwondo", 2));
        sports.add(new Sport("boxeo", 1));
        sports.add(new Sport("futbol", 4));

        persons.add(new Person("randy", "mendoza", 22, sports.get(0)));
        persons.add(new Person("cami", "rodriguez", 30, sports.get(1)));
        persons.add(new Person("nico", "mamud", 35, sports.get(2)));
    }

    @GetMapping("/findSports")
    public ResponseEntity<List<SportDTO>> getAllSports() {
        List<SportDTO> sportsDTO = sports.stream().map(sport -> new SportDTO(sport.getName(), sport.getLevel())).toList();
        return ResponseEntity.ok(sportsDTO);
    }

    @GetMapping("/findSports/{name}")
    public ResponseEntity<String> getSportLevelByName(@PathVariable("name") String sportName) {
        Optional<Sport> sportEntity = sports.stream()
                .filter(sport -> sport.getName().equals(sportName)).findFirst();

        return sportEntity
                .map(sport -> ResponseEntity.ok(String.format("Level: %s", sport.getLevel())))
                .orElseGet(() -> new ResponseEntity<>(String.format("sportName: <%s> not found", sportName), HttpStatus.NOT_FOUND));
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<SportPersonDTO>> getSportPersons() {
        List<SportPersonDTO> sportPersons = persons.stream()
                .map(person -> new SportPersonDTO(person.getName(), person.getLastname(), person.getSport().getName()))
                .toList();

        return ResponseEntity.ok(sportPersons);

    }


}
