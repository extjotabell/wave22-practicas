package com.bootcamp.elastic.controller;

import com.bootcamp.elastic.dto.request.DateDTO;
import com.bootcamp.elastic.entity.Literature;
import com.bootcamp.elastic.repository.LiteratureRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/literature")
public class LiteratureController {

    LiteratureRepository literatureRepository;

    public LiteratureController ( LiteratureRepository literatureRepository ) {
        this.literatureRepository = literatureRepository;
    }

    @GetMapping("")
    public ResponseEntity<?> getBooks () {
        return new ResponseEntity<>(literatureRepository.findAll(), OK);
    }

    @GetMapping("/autor/{autor}")
    public ResponseEntity<?> getBooksByAuthor (@PathVariable String autor) {
        return new ResponseEntity<>(literatureRepository.findByAuthor(autor), OK);
    }

    @GetMapping("/editorial/{editorial}")
    public ResponseEntity<?> getBooksByEditorial (@PathVariable String editorial) {
        return new ResponseEntity<>(literatureRepository.findByEditorial(editorial), OK);
    }

    @PostMapping
    public ResponseEntity<?> saveBooks ( @RequestBody List<Literature> books ) {
        return new ResponseEntity<>(literatureRepository.saveAll(books), CREATED);
    }

    @DeleteMapping("")
    public ResponseEntity<?> deleteAllBooks () {
        literatureRepository.deleteAll();
        return new ResponseEntity<>("https://www.youtube.com/watch?v=i_cVJgIz_Cs", OK);
    }

    @GetMapping("/titleContains/{titleContains}")
    public ResponseEntity<?> getBooksByTitleThatContains(@PathVariable String titleContains){
        return new ResponseEntity<>(literatureRepository.findByTitleContains(titleContains), OK);
    }

    @GetMapping("/pagesGreaterThan/{pages}")
    public ResponseEntity<?> getBooksByPagesGreaterThan(@PathVariable Integer pages){
        return new ResponseEntity<>(literatureRepository.findByCantPagesGreaterThan(pages), OK);
    }

    @GetMapping("/postBefore")
    public ResponseEntity<?> getFirstPostBeforeDate(@RequestParam @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate date){
        return new ResponseEntity<>(literatureRepository.findByFirstPostBefore(date), OK);
    }

    @GetMapping("/postAfter")
    public ResponseEntity<?> getFirstPostAfterDate(@RequestParam @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate date){
        return new ResponseEntity<>(literatureRepository.findByFirstPostAfter(date), OK);

    }
}
