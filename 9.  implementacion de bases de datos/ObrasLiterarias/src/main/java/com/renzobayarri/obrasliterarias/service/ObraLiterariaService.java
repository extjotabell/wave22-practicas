package com.renzobayarri.obrasliterarias.service;

import com.renzobayarri.obrasliterarias.dto.ObraLiterariaDTO;
import com.renzobayarri.obrasliterarias.entity.ObraLiteraria;

import java.util.List;

public interface ObraLiterariaService {


    List<ObraLiterariaDTO> getByAutor(String name);

    List<ObraLiterariaDTO> findAllByNameContains(String title);

    List<ObraLiterariaDTO> findAllByPagesGreaterThan(int pages);

    List<ObraLiterariaDTO> findAllByPublicationYearGreaterThan(int year);

    List<ObraLiterariaDTO> findAllByPublicationYearLessThan(int year);

    List<ObraLiterariaDTO> findAllByPublisher(String publisher);

    ObraLiterariaDTO toDTO(ObraLiteraria obraLiteraria);

    ObraLiteraria toEntity(ObraLiterariaDTO obraLiterariaDTO);

}
