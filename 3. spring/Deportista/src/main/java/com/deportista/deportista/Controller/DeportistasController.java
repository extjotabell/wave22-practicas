package com.deportista.deportista.Controller;

import com.deportista.deportista.DTO.DeporteDTO;
import com.deportista.deportista.Models.Deporte;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Sports")
public class DeportistasController {

    @GetMapping("/findSports")
    public ResponseEntity<List<DeporteDTO>> GetAllSport(){
        Deporte deporte =  new Deporte();
        List<Deporte> listDeporte =deporte.GetListDeporte();

        List<DeporteDTO> deporteDTOS = listDeporte.stream().map(x->new DeporteDTO(x.getNombre(),x.getNivel())).collect(Collectors.toList());

        return ResponseEntity.ok(deporteDTOS);
    }

    @GetMapping("/findSports/{name}")
    public ResponseEntity<DeporteDTO> GetSport(PathVariable String name){
        Deporte deporte =  new Deporte();
        List<Deporte> listDeporte =deporte.GetListDeporte();

        DeporteDTO deporteDTO =listDeporte.stream().filter(x -> x.equals(name)).map(x -> new DeporteDTO(x.getNombre(),x.getNivel())).findFirst();

        return ResponseEntity.ok(deporteDTO);
    }
}
