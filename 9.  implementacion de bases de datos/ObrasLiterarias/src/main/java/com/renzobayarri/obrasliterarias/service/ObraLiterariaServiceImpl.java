package com.renzobayarri.obrasliterarias.service;

import com.renzobayarri.obrasliterarias.dto.ObraLiterariaDTO;
import com.renzobayarri.obrasliterarias.entity.ObraLiteraria;
import com.renzobayarri.obrasliterarias.repository.IObraLiterariaRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ObraLiterariaServiceImpl implements ObraLiterariaService {

    private IObraLiterariaRepository repository;

    private ModelMapper mapper;


    //    Retornar las obras de un autor dado por el usuario.
    public List<ObraLiterariaDTO> getByAutor(String author) {
        return repository.findAllByAuthor(author).stream().map(this::toDTO).toList();
    }

    //    Retornar las obras que contengan palabras dadas por el usuario en sus títulos.
    public List<ObraLiterariaDTO> findAllByNameContains(String title) {
        return repository.findAllByNameContains(title).stream().map(this::toDTO).toList();
    }

    //    Retornar las obras con más cantidad de páginas que las indicadas por el usuario.
    public List<ObraLiterariaDTO> findAllByPagesGreaterThan(int pages) {
        return repository.findAllByPagesGreaterThan(pages).stream().map(this::toDTO).toList();
    }

    //    Retornar las obras que fueron publicadas antes y después de un año dado por el usuario (crear 2 endpoints).
    public List<ObraLiterariaDTO> findAllByPublicationYearGreaterThan(int year) {
        return repository.findAllByFirstPublicationYearGreaterThan(year).stream().map(this::toDTO).toList();
    }

    public List<ObraLiterariaDTO> findAllByPublicationYearLessThan(int year) {
        return repository.findAllByFirstPublicationYearLessThan(year).stream().map(this::toDTO).toList();
    }

    //    Retornar las obras de una misma editorial.
    public List<ObraLiterariaDTO> findAllByPublisher(String publisher) {
        return repository.findAllByPublisher(publisher).stream().map(this::toDTO).toList();
    }

    @Override
    public ObraLiterariaDTO toDTO(ObraLiteraria obraLiteraria) {
        return mapper.map(obraLiteraria, ObraLiterariaDTO.class);
    }

    @Override
    public ObraLiteraria toEntity(ObraLiterariaDTO obraLiterariaDTO) {
        return mapper.map(obraLiterariaDTO, ObraLiteraria.class);
    }
}
