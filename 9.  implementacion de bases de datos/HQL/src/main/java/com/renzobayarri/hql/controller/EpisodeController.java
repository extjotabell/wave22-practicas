package com.renzobayarri.hql.controller;

import com.renzobayarri.hql.dto.EpisodeDTO;
import com.renzobayarri.hql.service.EpisodeService;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/episodes")
@AllArgsConstructor
public class EpisodeController {

    private EpisodeService episodeService;

    @GetMapping("/actors/{lastName}")
    public ResponseEntity<List<EpisodeDTO>> findAllByActorLastName(@PathVariable @NotNull(message = "lastname is mandatory") String lastName) {
        return ResponseEntity.ok(episodeService.findAllByActorLastName(lastName));
    }
}
