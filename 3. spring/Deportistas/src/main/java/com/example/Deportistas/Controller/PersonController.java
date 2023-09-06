package com.example.Deportistas.Controller;

import com.example.Deportistas.Modelo.Level;
import com.example.Deportistas.Modelo.Person;
import com.example.Deportistas.Modelo.Sport;
import com.example.Deportistas.Modelo.dto.SportDTO;
import com.example.Deportistas.Modelo.dto.SportsPersonDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/people")
public class PersonController {

    Map<Person, List<Sport>> fitPeople = new HashMap<>();

    PersonController(){
        Person person1 = new Person("Pepito", "Perez", 20);
        Person person2 = new Person("Maria", "Gomez", 30);
        List<Sport> sports = new ArrayList<>();
        List<Sport> sports2 = new ArrayList<>();
        sports.add(new Sport("football", Level.INTERMEDIO));
        sports.add(new Sport("voley", Level.PRINCIPIANTE));
        sports2.add(new Sport("hockey", Level.AVANZADO));
        sports2.add(new Sport("basket", Level.PRINCIPIANTE));
        fitPeople.put(person1, sports);
        fitPeople.put(person2, sports2);
    }

    @GetMapping("/fitPeople")
    public ResponseEntity<List<SportsPersonDTO>> getSportsPeople(){
        List<SportsPersonDTO> sportsPeople = new ArrayList<>();
        for (Map.Entry<Person,List<Sport>> entry: fitPeople.entrySet()) {
            List<SportDTO> sportList = new ArrayList<>();
            entry.getValue().forEach(sport ->  sportList.add(new SportDTO(sport.getName(), null)));
            String fullName = entry.getKey().getName()+" "+entry.getKey().getSurname();
            sportsPeople.add(new SportsPersonDTO(fullName, sportList));
        }
        return new ResponseEntity<>(sportsPeople, HttpStatus.OK);
    }
}
