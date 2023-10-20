package salvo.nicolas.movieshql.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import salvo.nicolas.movieshql.service.ISerieService;

@RestController
@RequestMapping("series")
public class SerieController {

    private final ISerieService serieService;

    public SerieController(ISerieService serieService) {
        this.serieService = serieService;
    }

    @GetMapping()
    public ResponseEntity<?> findSeriesThatSeasonsGreaterThan(@RequestParam Integer seasonNumber) {
        return ResponseEntity.ok(serieService.findSeriesThatSeasonsGreaterThan(seasonNumber));
    }
}
