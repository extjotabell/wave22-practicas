package com.renzobayarri.obrasliterarias.controller;

import com.renzobayarri.obrasliterarias.dto.ObraLiterariaDTO;
import com.renzobayarri.obrasliterarias.service.ObraLiterariaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class ObraLiterariaController {

    private final ObraLiterariaService obraLiterariaService;

    @GetMapping("/byAutor/{name}")
    public ResponseEntity<List<ObraLiterariaDTO>> getObraByAutor(@PathVariable String name) {
        return new ResponseEntity<>(obraLiterariaService.getByAutor(name), HttpStatus.OK);
    }

    @GetMapping("/words/{word}")
    public ResponseEntity<List<ObraLiterariaDTO>> getObraByWord(@PathVariable String word) {
        return new ResponseEntity<>(obraLiterariaService.findAllByNameContains(word), HttpStatus.OK);
    }

    @GetMapping("/numPages/{pages}")
    public ResponseEntity<List<ObraLiterariaDTO>> getObraWithMorePages(@PathVariable int pages) {
        return new ResponseEntity<>(obraLiterariaService.findAllByPagesGreaterThan(pages), HttpStatus.OK);
    }

    @GetMapping("/getAfterYear/{year}")
    public ResponseEntity<List<ObraLiterariaDTO>> getObraAfterYear(@PathVariable int year) {
        return new ResponseEntity<>(obraLiterariaService.findAllByPublicationYearGreaterThan(year), HttpStatus.OK);
    }

    @GetMapping("/getBeforeYear/{year}")
    public ResponseEntity<List<ObraLiterariaDTO>> getObraBeforeYear(@PathVariable int year) {
        return new ResponseEntity<>(obraLiterariaService.findAllByPublicationYearLessThan(year), HttpStatus.OK);
    }

    @GetMapping("/getByPublisher/{publisher}")
    public ResponseEntity<List<ObraLiterariaDTO>> getObraByPublisher(@PathVariable String publisher) {
        return new ResponseEntity<>(obraLiterariaService.findAllByPublisher(publisher), HttpStatus.OK);
    }

}
