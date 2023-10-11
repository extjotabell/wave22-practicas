package com.example.showroom.controller;

import com.example.showroom.dto.PrendaDto;
import com.example.showroom.dto.SaleDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sale") public class SaleController {

    @PostMapping()
    public ResponseEntity<?> postSale(@RequestBody SaleDto saleDto)
    {
        //return new ResponseEntity<>(, HttpStatus.OK);
        return null;
    }

    @GetMapping()
    public ResponseEntity<List<SaleDto>> getSales()
    {
        //return new ResponseEntity<>(, HttpStatus.OK);
        return null;
    }

    @GetMapping("/{number}")
    public ResponseEntity<SaleDto> getSaleByNumber(@PathVariable Integer number)
    {
        //return new ResponseEntity<>(, HttpStatus.OK);
        return null;
    }

    @PutMapping("/{number}")
    public ResponseEntity<SaleDto> getSaleByNumber(@PathVariable Integer number, @RequestBody SaleDto sale)
    {
        //return new ResponseEntity<>(, HttpStatus.OK);
        return null;
    }

    @DeleteMapping("/{number}")
    public ResponseEntity<SaleDto> deleteSaleByNumber(@PathVariable Integer number)
    {
        //return new ResponseEntity<>(, HttpStatus.OK);
        return null;
    }

    @GetMapping("/date")
    public ResponseEntity<List<SaleDto>> getSalesByDate(@RequestParam String date)
    {
        //return new ResponseEntity<>(, HttpStatus.OK);
        return null;
    }

    @GetMapping("/clothes/{number}")
    public ResponseEntity<List<PrendaDto>> getClothesBySale(@PathVariable Integer number)
    {
        //return new ResponseEntity<>(, HttpStatus.OK);
        return null;
    }

}
