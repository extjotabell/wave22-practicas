package com.ejercicios.linktracker.controller;

import com.ejercicios.linktracker.dto.LinkDTO;
import com.ejercicios.linktracker.service.IService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@RestController
public class LinkController {

    @Autowired
    IService service;
    @PostMapping("/link")
    public ResponseEntity<?> postNewLink(@RequestBody LinkDTO linkDTO){
        return new ResponseEntity<>(service.save(linkDTO), HttpStatus.OK);
    }

    @GetMapping("/link")
    public ResponseEntity<?> getAllPersonajes(){
        HashMap<Integer,LinkDTO> linkDTOList = service.getAll();
        return new ResponseEntity<>(linkDTOList, HttpStatus.OK);
    }


    @GetMapping("/link/{linkId}")
    public ResponseEntity<?> redirect(@PathVariable String linkId, @RequestParam String password) {

        int linkIdAsInt;
        try {
            linkIdAsInt = Integer.parseInt(linkId);
        } catch (NumberFormatException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Enlace no válido");
        }

        try{
            LinkDTO link = (LinkDTO) service.getById(linkIdAsInt);
            String originalUrl = link.getUrl();
            if(service.validarPassword(link, password)){
                service.countRedirect(link);
                return ResponseEntity.status(HttpStatus.FOUND).header("Location", originalUrl).build();
            }else{
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("No esta autorizado");
            }
        } catch (NullPointerException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Enlace con ID " + linkId +" no existe ");
        }

    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<?> metrics(@PathVariable String linkId){

        int linkIdAsInt;
        try {
            linkIdAsInt = Integer.parseInt(linkId);
        } catch (NumberFormatException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Enlace no válido");
        }

        try{
            LinkDTO link = (LinkDTO) service.getById(linkIdAsInt);
            Integer count = link.getCount();
            return ResponseEntity.status(HttpStatus.OK).body("Cantidad de redirecciones: " + count);
        } catch (NullPointerException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Enlace con ID " + linkId +" no existe ");
        }
    }

    @PostMapping("invalidate/{linkId}")
    public ResponseEntity<?> invalidate(@PathVariable String linkId){
        int linkIdAsInt;
        try {
            linkIdAsInt = Integer.parseInt(linkId);
        } catch (NumberFormatException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Enlace no válido");
        }

        try{
            LinkDTO link = (LinkDTO) service.getById(linkIdAsInt);
            service.invalidarLink(link);
            return ResponseEntity.status(HttpStatus.OK).body("El enlace " + linkIdAsInt + " ha sido invalidado");
        } catch (NullPointerException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Enlace con ID " + linkId +" no existe ");
        }
    }

}
