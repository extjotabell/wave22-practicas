package com.renzobayarri.hql.controller;

import com.renzobayarri.hql.dto.SerieDTO;
import com.renzobayarri.hql.service.SerieService;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/series")
@AllArgsConstructor
public class SerieController {

    private SerieService serieService;

    @GetMapping("/seasons/{number}")
    public ResponseEntity<List<SerieDTO>> findAllByNumberOfSeasons(@PathVariable @NotNull(message = "number is mandatory") Integer number) {
        return ResponseEntity.ok(serieService.findAllByMinimumNumberOfSeasons(number));
    }

}
