package com.clothes.controller;

import com.clothes.dto.SaleDTO;
import com.clothes.service.ISaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/sale")
public class SaleController {
    @Autowired
    ISaleService saleService;

    @PostMapping("")
    public ResponseEntity<?> createSale(@RequestBody SaleDTO saleDTO){
        return new ResponseEntity<>(saleService.addSale(saleDTO), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<?> getAllSales(@RequestParam(required = false) @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate date){
        if (date != null) {
            return new ResponseEntity<>(saleService.getAllClothesBySaleDate(date), HttpStatus.OK);
        }
        return new ResponseEntity<>(saleService.getAllSale(), HttpStatus.OK);
    }

    @GetMapping("/{number}")
    public ResponseEntity<?> getSale(@PathVariable Long number){
        return new ResponseEntity<>(saleService.getSale(number), HttpStatus.OK);
    }

    @PutMapping("/{number}")
    public ResponseEntity<?> updateSale(@PathVariable long number, @RequestBody SaleDTO saleToUpdate){
        return new ResponseEntity<>(saleService.updateSale(number, saleToUpdate), HttpStatus.OK);
    }

    @DeleteMapping("/{number}")
    public ResponseEntity<?> deleteSale(@PathVariable long number){
        return new ResponseEntity<>(saleService.deleteSale(number), HttpStatus.OK);
    }

    @GetMapping("/clothes/{number}")
    public ResponseEntity<?> getAllClothesBySaleNumber(@PathVariable long number){
        return new ResponseEntity<>(saleService.getAllClothesListBySaleNumber(number), HttpStatus.OK);
    }
}
