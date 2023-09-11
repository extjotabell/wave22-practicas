package com.example.link_tracker.controller;

import com.example.link_tracker.dto.CreateLinkDTO;
import com.example.link_tracker.dto.InvalidateLinkDTO;
import com.example.link_tracker.dto.LinkDTO;
import com.example.link_tracker.dto.MetricDTO;
import com.example.link_tracker.services.ILinkService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class LinkController {

    ILinkService service;

    public LinkController(ILinkService service){
        this.service = service;
    }

    @PostMapping("/createLink")
    public ResponseEntity<LinkDTO> createLink(@RequestBody CreateLinkDTO url){
        LinkDTO linkCreated =  service.createLink(url);
        return new ResponseEntity<>(linkCreated, HttpStatus.CREATED);
    }

    @GetMapping("/link/{id}")
    public void redirectLink(@PathVariable int id, HttpServletResponse response) throws IOException {
        String url = service.redirect(id);
        response.sendRedirect(url);
    }

    @GetMapping("/metrics/{id}")
    public ResponseEntity<MetricDTO> getStatistics(@PathVariable int id){
        MetricDTO linkMetric = service.getLinkMetrics(id);
        return new ResponseEntity<>(linkMetric, HttpStatus.OK);
    }

    @PostMapping("/invalidate/{id}")
    public ResponseEntity<String> invalidateLink(@PathVariable int id){
        service.invalidateLink(id);
        return new ResponseEntity<>("Link invalidated", HttpStatus.OK);
    }


}
