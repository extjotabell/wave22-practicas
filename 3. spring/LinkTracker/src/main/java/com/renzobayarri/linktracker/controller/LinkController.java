package com.renzobayarri.linktracker.controller;

import com.renzobayarri.linktracker.dto.LinkDTO;
import com.renzobayarri.linktracker.dto.LinkRequestDto;
import com.renzobayarri.linktracker.service.LinkService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@AllArgsConstructor
public class LinkController {

    private LinkService linkService;

    @PostMapping("/create")
    public ResponseEntity<LinkDTO> createLink(@RequestBody LinkRequestDto linkRequestDto) {
        return ResponseEntity.ok(linkService.add(linkRequestDto));
    }

    @PostMapping("/invalidate/{linkId}")
    public ResponseEntity<?> invalidate(@PathVariable int linkId) {
        linkService.inactivate(linkId);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/link/{linkId}")
    public ResponseEntity<?> redirect(@PathVariable int linkId, @RequestParam String password, HttpServletResponse response) throws IOException {
        String url = linkService.getUrl(linkId, password);
        linkService.increaseCounter(linkId);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "http://localhost:8080/" + url);
        return new ResponseEntity<>(headers, HttpStatus.FOUND);
    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<?> getQuantity(@PathVariable int linkId) {
        return ResponseEntity.ok(linkService.getQuantity(linkId));
    }

    @GetMapping("/{url}")
    public ResponseEntity<String> showPage(@PathVariable String url) {
        linkService.validarUrl(url);
        return ResponseEntity.ok("Redirección correcta");
    }
}
