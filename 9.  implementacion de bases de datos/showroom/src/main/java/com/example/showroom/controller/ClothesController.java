package com.example.showroom.controller;

import com.example.showroom.dto.PrendaDto;
import com.example.showroom.service.IPrendaService;
import org.springframework.beans.factory.annotation.Autowired;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clothes")
@AllArgsConstructor
public class ClothesController {

    private final IPrendaService service;

    /* Crear una nueva prenda. */
    @PostMapping
    public ResponseEntity<PrendaDto> createPrenda(@RequestBody PrendaDto prendaDto){
        return new ResponseEntity<>(service.newPrenda(prendaDto), HttpStatus.OK);
    }

    /*Devolver todas las prendas*/
    @GetMapping
    public ResponseEntity<List<PrendaDto>> getAllPrenda(){
        return new ResponseEntity<>(service.getAllPrendas(), HttpStatus.OK);
    }

    /*Devolver una prenda en particular*/
    @GetMapping("/{code}")
    public ResponseEntity<PrendaDto> getPrendaByCode(@PathVariable int code){
        return new ResponseEntity<>(service.getPrendaById(code), HttpStatus.OK);
    }

    /*Actualizar una prenda en particular*/
    @PutMapping("/{code}")
    public ResponseEntity<PrendaDto> updatePrenda(@PathVariable Integer idPrenda, @RequestBody PrendaDto prendaDto){
        return new ResponseEntity<>(service.updatePrenda(idPrenda ,prendaDto), HttpStatus.OK);
    }

    /*Eliminar una prenda en particular*/
    @DeleteMapping("/{code}")
    public ResponseEntity<PrendaDto> deletePrenda(@PathVariable int code){
        return new ResponseEntity<>(service.deletePrendaById(code), HttpStatus.OK);
    }

    /*Traer todas las prendas de un determinado talle*/
    @GetMapping("/{size}")
    public ResponseEntity<List<PrendaDto>> getPrendaBySize(@PathVariable String size){
        return new ResponseEntity<>(service.getPrendasByTalle(size), HttpStatus.OK);
    }

    /*Buscar todas las prendas en cuyo nombre aparezca la palabra “remera”. No se tienen en cuenta ni mayúsculas ni minúsculas*/
    @GetMapping("/containing")
    public ResponseEntity<List<PrendaDto>> getPrendaByName(@RequestParam String name){
        return new ResponseEntity<>(service.getPrendasContaining(name), HttpStatus.OK);
    }
}
