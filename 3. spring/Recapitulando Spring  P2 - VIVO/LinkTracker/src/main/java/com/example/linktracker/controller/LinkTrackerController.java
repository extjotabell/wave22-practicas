package com.example.linktracker.controller;

import com.example.linktracker.dto.LinkDTO;
import com.example.linktracker.service.ILinkService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URI;

@RestController
@RequestMapping("/link")
@RequiredArgsConstructor
public class LinkTrackerController {

    private final ILinkService linkService;

    @PostMapping
    public ResponseEntity<Integer> createLink(@RequestBody LinkDTO linkDTO){
        return ResponseEntity.ok(linkService.createLink(linkDTO));
    }

    @PostMapping("/invalidate/{linkId}")
    public ResponseEntity<Void> invalidateLink(@PathVariable int linkId){
        linkService.invalidateLink(linkId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping({"/{linkId}"})
    public ResponseEntity<?> redirectLink(@PathVariable int linkId, @RequestParam String pass) {
        if (this.linkService.isValidLink(linkId) && linkService.isValidPassword(pass, linkId)) {
            linkService.increaseRedirectAmount(linkId);
            String urlToRedirect;
            urlToRedirect = this.linkService.getUrlLinkById(linkId);
            return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(urlToRedirect)).build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/metrics/{linkID}")
    public ResponseEntity<Integer> getMetric(@PathVariable int linkID){
        return ResponseEntity.ok(linkService.getMetric(linkID));
    }

}
