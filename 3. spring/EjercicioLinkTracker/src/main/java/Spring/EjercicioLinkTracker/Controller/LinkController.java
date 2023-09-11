package Spring.EjercicioLinkTracker.Controller;

import Spring.EjercicioLinkTracker.Dtos.CreateLinkDto;
import Spring.EjercicioLinkTracker.Entities.Link;
import Spring.EjercicioLinkTracker.Service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
@RequestMapping("/link")
public class LinkController {
    @Autowired
    private LinkService linkService;

    @PostMapping("/create")
    public ResponseEntity<String> createLink(@RequestBody CreateLinkDto linkDto) {
        return ResponseEntity.ok(linkService.createLink(linkDto));
    }

    @GetMapping("/redirect/{linkId}")
    public ResponseEntity<RedirectView> redirect(@PathVariable Integer linkId) {
        return ResponseEntity.ok(new RedirectView(linkService.redirect(linkId)));
    }

    @GetMapping("/metrics/{linkID}")
    public ResponseEntity<Integer> getCantidadRedirecciones(@PathVariable String linkID) {
        return ResponseEntity.ok(linkService.getCantidadRedirecciones(linkID));
    }

    @PostMapping("/invalidate/{linkID}")
    public ResponseEntity<Boolean> invalidateLink(@PathVariable String linkID) {
        return ResponseEntity.ok(linkService.invalidateLink(linkID));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Link>> getAllLinks(){
        return ResponseEntity.ok(linkService.getAll());
    }
}