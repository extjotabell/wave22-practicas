package com.clothes.service;

import com.clothes.dto.ClotheDto;
import com.clothes.dto.SaleDTO;

import java.time.LocalDate;
import java.util.List;

public interface ISaleService {

    SaleDTO addSale(SaleDTO dto);
    List<SaleDTO> getAllSale();
    SaleDTO getSale(long number);
    SaleDTO updateSale(long number, SaleDTO dto);
    SaleDTO deleteSale(long number);
    List<ClotheDto> getAllClothesListBySaleNumber(long number);
    List<ClotheDto> getAllClothesBySaleDate(LocalDate date);
}
