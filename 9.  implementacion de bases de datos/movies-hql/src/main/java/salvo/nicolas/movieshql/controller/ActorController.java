package salvo.nicolas.movieshql.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import salvo.nicolas.movieshql.service.IActorService;

@RestController
@RequestMapping("actors")
public class ActorController {

    private final IActorService actorService;

    public ActorController(IActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping("haveFavoriteMovie")
    public ResponseEntity<?> findActorThatHaveFavoriteMovie() {
        return ResponseEntity.ok(actorService.findActorsThatHaveFavoriteMovie());
    }

    @GetMapping()
    public ResponseEntity<?> findActorByRating(@RequestParam Double rating) {
        return ResponseEntity.ok(actorService.findActorsWithRankingOf(rating));
    }

    @GetMapping("movies/{movieId}")
    public ResponseEntity<?> findActorsThatWorksInMovie(@PathVariable Integer movieId) {
        return ResponseEntity.ok(actorService.findActorsThatWorksInMovie(movieId));
    }
}
