package com.bootcamp.elastic.controller;

import com.bootcamp.elastic.entity.Literature;
import com.bootcamp.elastic.repository.LiteratureRepository;
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

    @PostMapping("")
    public ResponseEntity<?> saveBooks ( @RequestBody List<Literature> books ) {
        return new ResponseEntity<>(literatureRepository.saveAll(books), CREATED);
    }

    @DeleteMapping("")
    public ResponseEntity<?> deleteAllBooks () {
        literatureRepository.deleteAll();
        return new ResponseEntity<>("https://www.youtube.com/watch?v=i_cVJgIz_Cs", OK);
    }

    /* querys */
    @GetMapping("/findByAuthor/{author}")
    public ResponseEntity<?> findByAuthor(@PathVariable String author) {
        return new ResponseEntity<>(literatureRepository.findByAuthor(author), OK);
    }

    @GetMapping("/findByTitleContains/{title}")
    public ResponseEntity<?> findByTitleContains(@PathVariable String title) {
        return new ResponseEntity<>(literatureRepository.findByTitleContains(title), OK);
    }

    @GetMapping("/findByCantPagesGreaterThan/{pages}")
    public ResponseEntity<?> findByCantPagesGreaterThan(@PathVariable Integer pages) {
        return new ResponseEntity<>(literatureRepository.findByCantPagesGreaterThan(pages), OK);
    }

    @GetMapping("/findByFirstPostBefore/{post}")
    public ResponseEntity<?> findByFirstPostBefore(@PathVariable LocalDate post) {
        return new ResponseEntity<>(literatureRepository.findByFirstPostBefore(post), OK);
    }

    @GetMapping("/findByFirstPostAfter/{post}")
    public ResponseEntity<?> findByFirstPostAfter(@PathVariable LocalDate post) {
        return new ResponseEntity<>(literatureRepository.findByFirstPostAfter(post), OK);
    }


    @GetMapping("/findByEditorial/{editorial}")
    public ResponseEntity<?> findByEditorial(@PathVariable String editorial) {
        return new ResponseEntity<>(literatureRepository.findByEditorial(editorial), OK);
    }

}
