package com.example.LinkTracker.controller;

import com.example.LinkTracker.dto.CreateLinkDTO;
import com.example.LinkTracker.dto.LinkDTO;
import com.example.LinkTracker.service.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("link")
public class LinkController {
    private final ILinkService linkService;

    public LinkController(ILinkService linkService) {
        this.linkService = linkService;
    }

    @PostMapping
    public ResponseEntity<Integer> createLink(@RequestBody CreateLinkDTO link){
        Integer id = linkService.createNewLink(link);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
    @PostMapping("invalidate/{linkId}")
    public ResponseEntity<?> invalidateLink(@PathVariable int linkId){
        linkService.invalidateLink(linkId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/redirect/{linkId}")
    public RedirectView redirect(@PathVariable int linkId, @RequestParam(required = false) String password){
        LinkDTO link = linkService.redirect(linkId, password);
        return new RedirectView(link.getUrl());
    }
}
