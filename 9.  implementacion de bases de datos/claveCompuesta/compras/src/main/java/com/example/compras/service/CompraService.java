package com.example.compras.service;

import com.example.compras.dto.CompraDTO;
import com.example.compras.model.Compra;
import com.example.compras.repository.CompraRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CompraService {

    private final CompraRepository compraRepository;

    @Autowired
    public CompraService(CompraRepository compraRepository) {
        this.compraRepository = compraRepository;
    }

    @Transactional
    public CompraDTO createCompra(CompraDTO compra) {
        ObjectMapper mapper = new ObjectMapper();
        Compra entity = mapper.convertValue(compra, Compra.class);
        compraRepository.save(entity);
        return mapper.convertValue(entity, CompraDTO.class);
    }

}