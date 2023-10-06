package com.example.joya.service;

import com.example.joya.dto.JewerlyDto;
import com.example.joya.exception.NotFoundException;
import com.example.joya.models.Jewerly;
import com.example.joya.repository.IJewerlyRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class JewerlyService implements IJewerlyService{

    private final IJewerlyRepository repo;
    private final ObjectMapper mapper;

    public JewerlyService(IJewerlyRepository repo){
        this.repo = repo;
        this.mapper =new ObjectMapper();
    }

    @Override
    @Transactional
    public Long createJewerly(JewerlyDto jewerlyDto) {
       Jewerly jewerly = mapper.convertValue(jewerlyDto, Jewerly.class);
       jewerly.setVentaONo(true);
       repo.save(jewerly);
       return jewerly.getNroIdentificatorio();
    }

    @Override
    @Transactional(readOnly = true)
    public List<JewerlyDto> getJewerlyAll() {
        List<Jewerly> jewerlyList=  repo.findAll().stream().filter(Jewerly::getVentaONo).toList();;
        return jewerlyList.stream().map(j->  mapper.convertValue(j, JewerlyDto.class))
                            .collect(Collectors.toList());
    }

    @Override
    public JewerlyDto deleteJewerly(Long id) {
        Jewerly jewerly = repo.findById(id).orElseThrow(
                () -> new NotFoundException("No se encuentra la joya con ese identificador"));

        jewerly.setVentaONo(false);
        repo.save(jewerly);
        return mapper.convertValue(jewerly, JewerlyDto.class);
    }

    @Override
    public JewerlyDto updateJewerly(JewerlyDto jewerlyDto, Long id) {
        Jewerly jewerly = mapper.convertValue(jewerlyDto, Jewerly.class);
        jewerly.setNroIdentificatorio(id);
        repo.save(jewerly);
        return mapper.convertValue(jewerly, JewerlyDto.class);
    }
}
