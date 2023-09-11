package com.example.LinkTracker.controller;

import com.example.LinkTracker.service.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

@RestController
@RequestMapping("/metrics")
public class MetricsController {

    @Autowired
    ILinkService linkService;
    @GetMapping("/{linkId}")
    public ResponseEntity<Integer> getVisits(@PathVariable int linkId){
        Integer visits = linkService.getVisits(linkId);
        return new ResponseEntity<>(visits, HttpStatus.OK);
    }
}
