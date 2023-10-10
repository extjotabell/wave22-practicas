package practicaHQL.practicaHQL.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import practicaHQL.practicaHQL.service.MovieService;

@RestController
@RequestMapping("/movie")
public class MovieController {

    MovieService service;

    public MovieController(MovieService service) {
        this.service = service;
    }

    @GetMapping("/moviesByRating/{rating}")
    public ResponseEntity<?> moviesByRating(@PathVariable double rating){
        return ResponseEntity.ok(service.moviesWithRatingMoreThan(rating));
    }

    @GetMapping("/movieByGenre/{genre}")
    public ResponseEntity<?> movieByGenre(@PathVariable String genre){
        return ResponseEntity.ok(service.moviesByGenre(genre));
    }
}
