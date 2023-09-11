package com.gym.deportistas.controllers;

import com.gym.deportistas.DeportistasApplication;
import com.gym.deportistas.models.Sport;
import com.gym.deportistas.models.dto.SportDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Sports {
    @GetMapping("/findSports")
    public ResponseEntity<?> findSports(){
        List<SportDTO> sportDTOS = new ArrayList<>();
        for (Sport s : DeportistasApplication.sports) {
            sportDTOS.add(new SportDTO(s.getName(), null));
        }
        return new ResponseEntity<>(sportDTOS, HttpStatus.OK);
    }
    @GetMapping("/findSport/{sportName}")
    public ResponseEntity<?> findSportsByName(@PathVariable String sportName){
        Sport sport = DeportistasApplication.sports.stream()
                .filter(x->x.getName().equalsIgnoreCase(sportName)).findFirst().orElse(null);
        SportDTO sportDTO = new SportDTO();
        sportDTO.setName(sport.getName());
        sportDTO.setLevel(sport.getLevel());
        return new ResponseEntity<>(sportDTO, HttpStatus.OK);
    }
}
