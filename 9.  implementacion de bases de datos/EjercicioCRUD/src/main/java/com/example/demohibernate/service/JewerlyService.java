package com.example.demohibernate.service;

import com.example.demohibernate.dto.JewerlyDto;
import com.example.demohibernate.exception.BadRequestException;
import com.example.demohibernate.exception.NotFoundException;
import com.example.demohibernate.model.Jewerly;
import com.example.demohibernate.repository.JewerlyRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JewerlyService implements IJewerlyService {
    private final JewerlyRepository jwyRepo;
    private ObjectMapper mapper;

    public JewerlyService(JewerlyRepository jwyRepo, ObjectMapper mapper){
        this.jwyRepo = jwyRepo;
        this.mapper = mapper;
    }

    @Override
    public List<JewerlyDto> getJewerly() {
        List<JewerlyDto> jewerlyDtoList = jwyRepo.findAll().stream()
                .filter(Jewerly::isOnSale)
                .map(j -> mapper.convertValue(j, JewerlyDto.class))
                .toList();


        if (jewerlyDtoList.isEmpty())
            throw new NotFoundException("Ninguna joya cargada");

        return  jewerlyDtoList;
    }

    @Override
    public Long saveJewerly(JewerlyDto dto) {
        Jewerly newJew = mapper.convertValue(dto, Jewerly.class);
        return jwyRepo.save(newJew).getIndentifyNumber();
    }

    @Override
    public void updateJewerly(long id, JewerlyDto dto) {
        if (!jwyRepo.existsById(id))
            throw new BadRequestException("La joya con el ID: " + id + " - no existe");

        Jewerly updateJewerly = jwyRepo.findById(id).get();

        updateJewerly.setName(dto.getName());
        updateJewerly.setMaterial(dto.getMaterial());
        updateJewerly.setWeight(dto.getWeight());
        updateJewerly.setParticularity(dto.getParticularity());
        updateJewerly.setHasStone(dto.isHasStone());

        jwyRepo.save(updateJewerly);
    }

    @Override
    public void deleteJewerly(long id) {
        if (!jwyRepo.existsById(id))
            throw new BadRequestException("La joya con el ID: " + id + " - no existe");

        Jewerly deleteJulery = jwyRepo.findById(id).get();
        deleteJulery.setOnSale(false);

        jwyRepo.save(deleteJulery);
    }

    @Override
    public JewerlyDto findJewerly(long id) {
        if (!jwyRepo.existsById(id))
            throw new NotFoundException("La joya con el ID: " + id + " - no existe");

        return mapper.convertValue(jwyRepo.findById(id), JewerlyDto.class);
    }
}
