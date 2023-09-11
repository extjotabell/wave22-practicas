package com.example.ejerciciolinktracker.controller;

import com.example.ejerciciolinktracker.dto.LinkDTO;
import com.example.ejerciciolinktracker.dto.LinkRequestDTO;
import com.example.ejerciciolinktracker.repository.LinkRepository;
import com.example.ejerciciolinktracker.service.LinkService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class LinkTrackerController {

    @Autowired
    private LinkService linkService;

    @PostMapping("/link")
    public ResponseEntity<Integer> crearLink(@RequestBody LinkRequestDTO link) {
        return ResponseEntity.ok(linkService.guardarLink(link));
    }

    @GetMapping("/link/{linkId}/{password}")
    public RedirectView redirect(@PathVariable String linkId, @PathVariable String password) {
        String url = linkService.getLink(Integer.parseInt(linkId), password).getUrl();
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(url);
        return redirectView;
    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<Integer> getMetrics(@PathVariable int linkId) {
        return ResponseEntity.ok(linkService.getRedirecciones(linkId));
    }

    @DeleteMapping("/invalidate/{linkId}")
    public ResponseEntity<String> invalidateLink(@PathVariable int linkId) {
        linkService.invalidarLink(linkId);
        return ResponseEntity.ok("Link invalidated");
    }

}
