package practicaHQL.practicaHQL.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import practicaHQL.practicaHQL.service.EpisodeService;

@RestController
@RequestMapping("/episode")
public class EpisodeController {
    EpisodeService service;

    public EpisodeController(EpisodeService service) {
        this.service = service;
    }

    @GetMapping("/episodeByActor")
    public ResponseEntity<?> episodeByActor(@RequestParam String actor){
        return ResponseEntity.ok(service.episodeByActorName(actor));
    }
}
