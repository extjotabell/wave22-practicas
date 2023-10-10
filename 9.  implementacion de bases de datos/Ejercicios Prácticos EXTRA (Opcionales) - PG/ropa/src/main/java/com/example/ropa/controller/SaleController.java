package com.example.ropa.controller;

import com.example.ropa.dto.ClothDTO;
import com.example.ropa.dto.SaleDTO;
import com.example.ropa.service.ISaleService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/sale")
public class SaleController {
    @Autowired
    ISaleService saleService;

    @PostMapping
    public ResponseEntity<SaleDTO> addSale(@RequestBody SaleDTO saleDto){
        return ResponseEntity.ok(saleService.addSale(saleDto));
    }

    @GetMapping
    public ResponseEntity<List<SaleDTO>> getAllSales(){
        return ResponseEntity.ok(saleService.getAllSales());
    }

    @GetMapping("number/{number}")
    public ResponseEntity<SaleDTO> getByNumber(@PathVariable Integer number){
        return ResponseEntity.ok(saleService.getSaleByNumber(number));
    }

    @PutMapping("/{number}")
    public void updateSale(@PathVariable Integer number, @RequestBody SaleDTO updatedSale){
        this.saleService.updateSale(number, updatedSale);
    }

    @DeleteMapping("/{number}")
    public void deleteSale(@PathVariable Integer number){
        this.saleService.deleteSale(number);
    }

    @GetMapping("/date")
    public ResponseEntity<List<SaleDTO>> getSaleByDate(@RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate date){
        return ResponseEntity.ok(this.saleService.getSaleByDate(date));
    }

    @GetMapping("/clothes/{number}")
    public ResponseEntity<List<ClothDTO>> getSaleClothes(@PathVariable Integer number){
        return ResponseEntity.ok(this.saleService.getSaleClothes(number));
    }
}
