package com.bootcamp.elastic.controller;

import com.bootcamp.elastic.dto.request.LiteratureDTO;
import com.bootcamp.elastic.entity.Literature;
import com.bootcamp.elastic.repository.LiteratureRepository;
import com.bootcamp.elastic.service.ILiteratureService;
import com.bootcamp.elastic.service.LiteratureServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/literature")
public class LiteratureController {

    ILiteratureService literatureService;

    public LiteratureController ( LiteratureServiceImpl literatureService ) {
        this.literatureService = literatureService;
    }

    @GetMapping("/word/{word}")
    public ResponseEntity<List<LiteratureDTO>> getObraByWord(@PathVariable String word) {
        return new ResponseEntity<>(literatureService.findAllByNameContains(word), HttpStatus.OK);
    }

    @GetMapping("/pages/{pages}")
    public ResponseEntity<List<LiteratureDTO>> getObraWithMorePages(@PathVariable int pages) {
        return new ResponseEntity<>(literatureService.findAllByPagesGreaterThan(pages), HttpStatus.OK);
    }

    @GetMapping("/afterYear/{year}")
    public ResponseEntity<List<LiteratureDTO>> getObraAfterYear(@PathVariable int year) {
        return new ResponseEntity<>(literatureService.findAllByPublicationYearGreaterThan(year), HttpStatus.OK);
    }

    @GetMapping("/beforeYear/{year}")
    public ResponseEntity<List<LiteratureDTO>> getObraBeforeYear(@PathVariable int year) {
        return new ResponseEntity<>(literatureService.findAllByPublicationYearLessThan(year), HttpStatus.OK);
    }

    @GetMapping("/publisher/{publisher}")
    public ResponseEntity<List<LiteratureDTO>> getObraByPublisher(@PathVariable String publisher) {
        return new ResponseEntity<>(literatureService.findAllByPublisher(publisher), HttpStatus.OK);
    }
}
