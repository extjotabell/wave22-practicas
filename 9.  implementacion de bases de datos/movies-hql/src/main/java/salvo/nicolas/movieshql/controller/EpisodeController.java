package salvo.nicolas.movieshql.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import salvo.nicolas.movieshql.service.IEpisodeService;

@RestController
@RequestMapping("episodes")
public class EpisodeController {

    private final IEpisodeService episodeService;

    public EpisodeController(IEpisodeService episodeService) {
        this.episodeService = episodeService;
    }

    @GetMapping("actors/{actorId}")
    public ResponseEntity<?> findEpisodesThatAnActorWorks(@PathVariable Integer actorId) {
        return ResponseEntity.ok(episodeService.findEpisodesByActorId(actorId));
    }
}
