package com.linkTracker.LinkTracker.controller;

import com.linkTracker.LinkTracker.dtos.LinkDTO;
import com.linkTracker.LinkTracker.entity.Link;
import com.linkTracker.LinkTracker.service.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class LinkController {

    @Autowired
    ILinkService service;

    @PostMapping("/link")
    public ResponseEntity<?> saveLink(@RequestBody LinkDTO link){
        return ResponseEntity.ok(service.saveLink(link).getId());
    }

    @GetMapping(value = "/link/{id}", params = "pass")
    public RedirectView redirect(@PathVariable int id, @RequestParam("pass") int pass){
        LinkDTO link = service.findById(id, pass);
        service.sumCount(id);
        return new RedirectView(link.getUrl());
    }

    @GetMapping("/metrics/{id}")
    public ResponseEntity<?> metrics(@PathVariable int id){
        return ResponseEntity.ok(service.metrics(id));
    }

    @PostMapping("/invalidate/{id}")
    public ResponseEntity<?> invalidate(@PathVariable int id){
        service.invalidate(id);
        return ResponseEntity.ok("Invalidado");
    }
}
