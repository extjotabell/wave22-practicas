package com.example.linkTracker.controller;

import com.example.linkTracker.dto.LinkTrackerDTO;
import com.example.linkTracker.service.ILinkTrackerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class LinkController {

    ILinkTrackerService service;
    public LinkController(ILinkTrackerService service){
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createNewLink(@RequestBody LinkTrackerDTO linktrackerDTO){
        int id = service.saveLink(linktrackerDTO);
        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }

    @GetMapping("/link/{id}")
    public RedirectView redirectToMaskedURL(@PathVariable int id, @RequestParam String password){
        return service.redirect(id, password);
    }

    @GetMapping("/metrics/{id}")
    public ResponseEntity<?> metricsById(@PathVariable int id){
        return new ResponseEntity<>(service.findLinkById(id).getContadorVisitas(), HttpStatus.OK);
    }

    @PostMapping("/invalidate/{id}")
    public ResponseEntity<?> invalidateLink(@PathVariable int id){
        service.invalidateLink(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
