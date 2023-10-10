package practicaHQL.practicaHQL.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import practicaHQL.practicaHQL.service.SerieService;

@RestController
@RequestMapping("/serie")
public class SerieController {
    SerieService service;

    public SerieController(SerieService service) {
        this.service = service;
    }

    @GetMapping("/serieBySeasons/{number_seasons}")
    public ResponseEntity<?> serieBySeasons(@PathVariable int number_seasons){
        return ResponseEntity.ok(service.seriesBySeasonsMoreThan(number_seasons));
    }
}
