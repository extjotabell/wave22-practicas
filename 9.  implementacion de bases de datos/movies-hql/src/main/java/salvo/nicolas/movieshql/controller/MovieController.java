package salvo.nicolas.movieshql.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import salvo.nicolas.movieshql.service.IActorService;
import salvo.nicolas.movieshql.service.IMovieService;

@RestController
@RequestMapping("movies")
public class MovieController {

    private final IMovieService movieService;

    public MovieController(IMovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("actors")
    public ResponseEntity<?> findMoviesThatActorsHaveRankingGreaterThan(@RequestParam Double rating) {
        return ResponseEntity.ok(movieService.findMoviesThatActorsHaveRankingGreaterThan(rating));
    }

    @GetMapping("genre/{genreId}")
    public ResponseEntity<?> findMoviesThatActorsHaveRankingGreaterThan(@PathVariable Integer genreId) {
        return ResponseEntity.ok(movieService.findMoviesOfGenreId(genreId));
    }
}
