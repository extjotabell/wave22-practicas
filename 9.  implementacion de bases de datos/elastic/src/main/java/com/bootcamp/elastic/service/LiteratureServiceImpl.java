package com.bootcamp.elastic.service;

import com.bootcamp.elastic.dto.request.LiteratureDTO;
import com.bootcamp.elastic.entity.Literature;
import com.bootcamp.elastic.repository.LiteratureRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class LiteratureServiceImpl implements ILiteratureService {
    @Autowired
    private LiteratureRepository literatureRepository;
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public List<LiteratureDTO> getByAutor(String author) {
        return literatureRepository.findAllByAuthor(author).stream().map(this::toDTO).toList();
    }

    @Override
    public List<LiteratureDTO> findAllByNameContains(String title) {
        return literatureRepository.findAllByNameContains(title).stream().map(this::toDTO).toList();
    }

    @Override
    public List<LiteratureDTO> findAllByPagesGreaterThan(int pages) {
        return literatureRepository.findAllByPagesGreaterThan(pages).stream().map(this::toDTO).toList();
    }

    @Override
    public List<LiteratureDTO> findAllByPublicationYearGreaterThan(int year) {
        return literatureRepository.findAllByFirstPublicationYearGreaterThan(year).stream().map(this::toDTO).toList();
    }

    @Override
    public List<LiteratureDTO> findAllByPublicationYearLessThan(int year) {
        return literatureRepository.findAllByFirstPublicationYearLessThan(year).stream().map(this::toDTO).toList();
    }

    @Override
    public List<LiteratureDTO> findAllByPublisher(String publisher) {
        return literatureRepository.findAllByPublisher(publisher).stream().map(this::toDTO).toList();
    }

    @Override
    public LiteratureDTO toDTO(Literature literature) {
        return objectMapper.convertValue(literature, LiteratureDTO.class);
    }

    @Override
    public Literature toEntity(LiteratureDTO literatureDTO) {
        return objectMapper.convertValue(literatureDTO, Literature.class);
    }
}
