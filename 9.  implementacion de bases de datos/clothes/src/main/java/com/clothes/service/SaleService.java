package com.clothes.service;

import com.clothes.dto.ClotheDto;
import com.clothes.dto.SaleDTO;
import com.clothes.model.Clothes;
import com.clothes.model.Sale;
import com.clothes.repository.ISaleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SaleService implements ISaleService{
    @Autowired
    ISaleRepository saleRepository;

    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public SaleDTO addSale(SaleDTO dto) {
        Sale sale = modelMapper.map(dto, Sale.class);
        return modelMapper.map(saleRepository.save(sale), SaleDTO.class);
    }

    @Override
    public List<SaleDTO> getAllSale() {
        List<Sale> allSales = saleRepository.findAll();
        return allSales.stream().map(sale -> modelMapper.map(sale,SaleDTO.class)).toList();
    }

    @Override
    public SaleDTO getSale(long number) {
        Sale sale = saleRepository.findById(number).orElse(null);
        if (sale == null) {
            throw new RuntimeException("No existe la prenda con número: " + number);
        }
        return modelMapper.map(sale, SaleDTO.class);
    }

    @Override
    public SaleDTO updateSale(long number, SaleDTO dto) {
        Sale foundSale = saleRepository.findById(number).orElse(null);
        if (foundSale == null) {
            throw new RuntimeException("No existe la prenda con número: " + number);
        }
        dto.setNumber(foundSale.getNumber());
        Sale saleToUpdate = modelMapper.map(dto, Sale.class);

        return modelMapper.map(saleRepository.save(saleToUpdate), SaleDTO.class);
    }

    @Override
    public SaleDTO deleteSale(long number) {
        Sale foundSale = saleRepository.findById(number).orElse(null);
        if (foundSale == null) {
            throw new RuntimeException("No existe la prenda con número: " + number);
        }
        SaleDTO saleDeleted = modelMapper.map(foundSale, SaleDTO.class);
        saleRepository.deleteById(number);
        return saleDeleted;
    }

    @Override
    public List<ClotheDto> getAllClothesListBySaleNumber(long number) {
        Sale sale = saleRepository.findById(number).orElse(null);
        if (sale == null) {
            throw new RuntimeException("No existe la prenda con número: " + number);
        }
        return sale.getClothesList().stream().map(clothes -> modelMapper.map(clothes, ClotheDto.class)).toList();
    }

    @Override
    public List<ClotheDto> getAllClothesBySaleDate(LocalDate date) {
        List<SaleDTO> saleDTOS = saleRepository.findAllBySaleDate(date).stream().map(sale -> modelMapper.map(sale, SaleDTO.class)).toList();
        List<Clothes> clothes = new ArrayList<>();
        for (SaleDTO saleDTO: saleDTOS) {
            clothes.addAll(saleDTO.getClothesList());
        }
        return clothes.stream().map(currentClothes -> modelMapper.map(currentClothes, ClotheDto.class)).toList();
    }
}
