package com.example.ropa.service;

import com.example.ropa.dto.ClothDTO;
import com.example.ropa.dto.SaleDTO;

import java.time.LocalDate;
import java.util.List;

public interface ISaleService {

    SaleDTO addSale(SaleDTO saleDTO);

    List<SaleDTO> getAllSales();

    SaleDTO getSaleByNumber(Integer number);

    SaleDTO updateSale(Integer number, SaleDTO saleDTO);

    void deleteSale(Integer number);

    List<SaleDTO> getSaleByDate(LocalDate date);

    List<ClothDTO> getSaleClothes(Integer number);

}
