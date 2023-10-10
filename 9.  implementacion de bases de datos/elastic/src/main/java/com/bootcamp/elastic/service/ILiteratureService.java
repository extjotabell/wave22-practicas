package com.bootcamp.elastic.service;

import com.bootcamp.elastic.dto.request.LiteratureDTO;
import com.bootcamp.elastic.entity.Literature;

import java.util.List;

public interface ILiteratureService {
    List<LiteratureDTO> getByAutor(String name);

    List<LiteratureDTO> findAllByNameContains(String title);

    List<LiteratureDTO> findAllByPagesGreaterThan(int pages);

    List<LiteratureDTO> findAllByPublicationYearGreaterThan(int year);

    List<LiteratureDTO> findAllByPublicationYearLessThan(int year);

    List<LiteratureDTO> findAllByPublisher(String publisher);

    LiteratureDTO toDTO(Literature obraLiteraria);

    Literature toEntity(LiteratureDTO obraLiterariaDTO);
}
