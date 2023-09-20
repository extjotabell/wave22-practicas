package com.linkTracker.linkTracker.controller;

import com.linkTracker.linkTracker.dto.LinkInputDto;
import com.linkTracker.linkTracker.dto.MessageDto;
import com.linkTracker.linkTracker.dto.RedirectCountDto;
import com.linkTracker.linkTracker.service.IServiceLink;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class Controller {
    private IServiceLink serviceLink;

    public Controller(IServiceLink serviceLink) {
        this.serviceLink = serviceLink;
    }

    @PostMapping("/createLink")
    public ResponseEntity<?> createLink(@RequestBody LinkInputDto linkInputDto){
        return new ResponseEntity<>(serviceLink.createLink(linkInputDto), HttpStatus.CREATED);
    }

    @GetMapping("link/{linkId}")
    public RedirectView redirect(@PathVariable int linkId, @RequestParam String password){
        return new RedirectView(serviceLink.redirect(linkId, password));
    }

    @GetMapping("metrics/{linkId}")
    public ResponseEntity<?> getMetrics(@PathVariable int linkId){
        return new ResponseEntity<>(new RedirectCountDto(serviceLink.getMetrics(linkId)), HttpStatus.OK);
    }

    @PostMapping("invalidate/{linkId}")
    public ResponseEntity<?> invalidateLink(@PathVariable int linkId){
        serviceLink.invalidateLink(linkId);
        return new ResponseEntity<>(new MessageDto("Link " + linkId + " invalidado"), HttpStatus.OK);
    }
}
