package com.example.link_tracker.controller;

import com.example.link_tracker.dto.CreateLinkDTO;
import com.example.link_tracker.dto.LinkDTO;
import com.example.link_tracker.services.ILinkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    ILinkService service;

    public Controller(ILinkService service){
        this.service = service;
    }

    @PostMapping("/createLink")
    public LinkDTO createLink(@RequestBody CreateLinkDTO url){
        return service.createLink(url);
    }

//    @GetMapping("/link")
//    public ResponseEntity<> redirectLink(@PathVariable int id){
//
//    }
//
//    @GetMapping("/metrics")
//    public ResponseEntity<?> getStatistics(@PathVariable int id){
//
//        LinkDTO metric = service.getLinkMetrics(id);
//
//        return new ResponseEntity<>(metric, HttpStatus.OK);
//    }
//
//    @PostMapping("/invalidate")
//    public void invalidateLink(@PathVariable int id){
//        service.invalidateLink(id);
//    }


}
