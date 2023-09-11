package com.example.Deportistas.Controller;

import com.example.Deportistas.Modelo.Level;
import com.example.Deportistas.Modelo.Sport;
import com.example.Deportistas.Modelo.dto.SportDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/sports")
public class SportsController {

    List<Sport> sports = new ArrayList<>();
    SportsController() {
        sports.add(new Sport("football", Level.INTERMEDIO));
        sports.add(new Sport("voley", Level.PRINCIPIANTE));
        sports.add(new Sport("hockey", Level.AVANZADO));
        sports.add(new Sport("basket", Level.PRINCIPIANTE));
    }

    @GetMapping("/findSports")
    public ResponseEntity<List<SportDTO>> getSports() {
        List<SportDTO> sportDTOS = new ArrayList<>();
        for(Sport sport : sports){
            SportDTO sportDTO = new SportDTO();
            sportDTO.setName(sport.getName());
            sportDTO.setLevel(sport.getLevel());
            sportDTOS.add(sportDTO);
        }
        return new ResponseEntity<>(sportDTOS, HttpStatus.OK);

    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<SportDTO> getSportByName(@PathVariable String name){
        Sport sportByName = sports.stream().filter(sport -> sport.getName().equals(name)).findFirst().orElse(null);
        SportDTO sportDto = new SportDTO();
        sportDto.setName(sportByName.getName());
        sportDto.setLevel(sportByName.getLevel());
        return new ResponseEntity<>(sportDto, HttpStatus.OK);
    }

}
