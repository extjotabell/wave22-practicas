package com.renzobayarri.hql.controller;

import com.renzobayarri.hql.dto.MovieDTO;
import com.renzobayarri.hql.service.MovieService;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movies")
@AllArgsConstructor
public class MovieController {

    private MovieService movieService;

    @GetMapping("/actors/rating/greater/{rating}")
    public ResponseEntity<List<MovieDTO>> findAllByActorRating(@PathVariable @NotNull(message = "rating is mandatory") Double rating) {
        return ResponseEntity.ok(movieService.findAllByActorsRatingGreaterThan(rating));
    }

    @GetMapping("/genre/{name}")
    public ResponseEntity<List<MovieDTO>> findAllByGenre(@PathVariable @NotNull(message = "name is mandatory") String name) {
        return ResponseEntity.ok(movieService.findAllByGenreName(name));
    }

}
