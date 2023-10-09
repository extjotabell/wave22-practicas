package com.renzobayarri.hql.controller;

import com.renzobayarri.hql.dto.ActorDTO;
import com.renzobayarri.hql.service.ActorService;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/actors")
public class ActorController {

    private ActorService actorService;

    @GetMapping("/withFavoriteMovie")
    public ResponseEntity<List<ActorDTO>> findAllWithFavoritesMovie() {
        return ResponseEntity.ok(actorService.actorsWithDeclararedFavoriteMovie());
    }

    @GetMapping("/rating/greater/{rating}")
    public ResponseEntity<List<ActorDTO>> findWithRatingGreaterThan(@PathVariable @NotNull(message = "rating is mandatory") Double rating) {
        return ResponseEntity.ok(actorService.actorsWithRatingGreaterThan(rating));
    }

    @GetMapping("/movie/title/{title}")
    public ResponseEntity<List<ActorDTO>> findAllByMovieTitle(@PathVariable @NotNull(message = "title is mandatory") String title) {
        return ResponseEntity.ok(actorService.actorsThatWorkInAMovie(title));
    }
}
