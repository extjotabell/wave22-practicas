package com.example.showroom.service;

import com.example.showroom.dto.PrendaDto;
import com.example.showroom.entity.Prenda;
import com.example.showroom.repository.IPrendaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PrendaService implements IPrendaService{
    IPrendaRepository prendaRepository;

    public PrendaService(IPrendaRepository prendaRepository){
        this.prendaRepository = prendaRepository;
    }

    ObjectMapper mapper = new ObjectMapper();

    public PrendaDto newPrenda(PrendaDto prendaDto){
        prendaRepository.save(mapper.convertValue(prendaDto, Prenda.class));
        return prendaDto;
    }

    public List<PrendaDto> getAllPrendas(){
        List<Prenda> prendas = prendaRepository.findAll();

        return prendas.stream().map(p -> mapper.convertValue(p, PrendaDto.class)).toList();
    }

    public PrendaDto getPrendaById(Integer id){
        Prenda prendaFounded = prendaRepository.findById(id).orElseThrow();
        return mapper.convertValue(prendaFounded, PrendaDto.class);
    }

    public PrendaDto updatePrenda(Integer id, PrendaDto prendaDto) {
        Optional<Prenda> prendaOptional = prendaRepository.findById(id);
        if(prendaOptional.isPresent()) {
            Prenda prenda = prendaOptional.get();

            prenda.setNombre(prendaDto.getNombre());
            prenda.setTipo(prendaDto.getTipo());
            prenda.setMarca(prenda.getMarca());
            prenda.setColor(prenda.getColor());
            prenda.setTalle(prendaDto.getTalle());
            prenda.setCantidad(prendaDto.getCantidad());
            prenda.setPrecioVenta(prendaDto.getPrecioVenta());

            prendaRepository.save(prenda);
            return mapper.convertValue(prenda, PrendaDto.class);
        } else {
            throw new EntityNotFoundException("La prenda con ID " + id + " no fue encontrada");
        }
    }

    public PrendaDto deletePrendaById(Integer id){
        Optional prenda = prendaRepository.findById(id);
        if(prenda.isPresent()){
            prendaRepository.deleteById(id);
            return mapper.convertValue(prenda, PrendaDto.class);
        }
        throw new EntityNotFoundException("No se encontró la entidad");
    }

    public List<PrendaDto> getPrendasByTalle(String talle){
        List<Prenda> prendas = prendaRepository.findPrendasByTalle(talle);
        if (!prendas.isEmpty())
        {
            return prendas.stream().map(p -> mapper.convertValue(p, PrendaDto.class)).toList();
        }
        throw new EntityNotFoundException("No se encontraron prendas");
    }

    public List<PrendaDto> getPrendasContaining(String contains){
        List<Prenda> prendas = prendaRepository.findPrendasByNombreContains(contains);
        if (!prendas.isEmpty())
        {
            return prendas.stream().map(p -> mapper.convertValue(p, PrendaDto.class)).toList();
        }
        throw new EntityNotFoundException("No se encontraron prendas");
    }
}
