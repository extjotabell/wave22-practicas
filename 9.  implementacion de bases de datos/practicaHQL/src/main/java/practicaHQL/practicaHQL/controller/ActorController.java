package practicaHQL.practicaHQL.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import practicaHQL.practicaHQL.service.ActorService;

@RestController
@RequestMapping("/actor")
public class ActorController {
    ActorService service;

    public ActorController(ActorService service) {
        this.service = service;
    }

    @GetMapping("/actorsFavoriteFilm")
    public ResponseEntity<?> actorsFavoriteFilm(){
        return ResponseEntity.ok(service.actorWithFavoriteFilm());
    }

    @GetMapping("/actorsByRating/{rating}")
    public ResponseEntity<?> actorsByRating(@PathVariable double rating){
        return ResponseEntity.ok(service.actorsRatingMoreThan(rating));
    }

    @GetMapping("/actorsByFilm")
    public ResponseEntity<?> actorsByFilm(@RequestParam String movie){
        return ResponseEntity.ok(service.actorsWorkInMovie(movie));
    }
}
