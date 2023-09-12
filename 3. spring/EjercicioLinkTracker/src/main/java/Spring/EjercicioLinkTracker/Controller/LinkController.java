package Spring.EjercicioLinkTracker.Controller;

import Spring.EjercicioLinkTracker.Dtos.CreateLinkDto;
import Spring.EjercicioLinkTracker.Service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/link")
public class LinkController {
    @Autowired
    private LinkService linkService;

    @PostMapping("/create")
    public ResponseEntity<String> createLink(@RequestBody CreateLinkDto linkDto) {
        return ResponseEntity.ok(linkService.createLink(linkDto));
    }

    @GetMapping("/{linkId}")
    public ResponseEntity<RedirectView> redirect(@PathVariable Integer linkId) {
        return ResponseEntity.ok(new RedirectView(linkService.redirect(linkId)));
    }

    @GetMapping("metrics/{linkID}")
    public ResponseEntity<Integer> getCantidadRedireccion(@PathVariable Integer linkID) {
        return ResponseEntity.ok(linkService.getCantidadRedireccion(linkID));
    }

    @PostMapping("/invalidate/linkID")
    public ResponseEntity<Boolean> invalidateLink(int linkID) {
        return ResponseEntity.ok(linkService.invalidateLink(linkID));
    }
}