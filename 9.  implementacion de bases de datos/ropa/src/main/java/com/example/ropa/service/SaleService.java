package com.example.ropa.service;

import com.example.ropa.dto.ClothDTO;
import com.example.ropa.dto.SaleDTO;
import com.example.ropa.entity.Cloth;
import com.example.ropa.entity.Sale;
import com.example.ropa.repository.ISaleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SaleService implements ISaleService{

    @Autowired
    ISaleRepository saleRepository;

    @Override
    public SaleDTO addSale(SaleDTO saleDTO) {
        ModelMapper mapper = new ModelMapper();
        Sale sale = mapper.map(saleDTO, Sale.class);
        saleRepository.save(sale);
        return saleDTO;
    }

    @Override
    public List<SaleDTO> getAllSales() {
        ModelMapper mapper = new ModelMapper();
        List<Sale> sales = saleRepository.findAll();

        return sales.stream().map(sale -> mapper.map(sale,SaleDTO.class)).toList();
    }

    @Override
    public SaleDTO getSaleByNumber(Integer number) {
        ModelMapper mapper = new ModelMapper();

        return saleRepository.findById(number)
                .map(c -> mapper.map(c, SaleDTO.class))
                .orElseThrow();
    }

    @Override
    public SaleDTO updateSale(Integer number, SaleDTO saleDTO) {
        Sale sale = saleRepository.findById(number).orElseThrow();
        sale.setTotal(saleDTO.getTotal());
        sale.setDate(saleDTO.getDate());
        sale.setPaidMethod(saleDTO.getPaidMethod());
        sale.setCloths(saleDTO.getCloths());
        saleRepository.save(sale);
        return saleDTO;
    }

    @Override
    public void deleteSale(Integer number) {
        saleRepository.findById(number)
                .ifPresent(sale -> saleRepository.delete(sale));
    }

    @Override
    public List<SaleDTO> getSaleByDate(LocalDate date) {
        ModelMapper mapper = new ModelMapper();
        return saleRepository.findByDate(date).stream()
                .map(sale -> mapper.map(sale, SaleDTO.class))
                .toList();
    }

    @Override
    public List<ClothDTO> getSaleClothes(Integer number) {
        ModelMapper mapper = new ModelMapper();
        List<Cloth> cloths = saleRepository.findById(number).orElseThrow().getCloths();
        return cloths.stream().map(c -> mapper.map(c, ClothDTO.class)).toList();
    }
}
