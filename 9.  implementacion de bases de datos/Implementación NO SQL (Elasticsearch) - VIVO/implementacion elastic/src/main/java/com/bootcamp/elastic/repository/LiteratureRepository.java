package com.bootcamp.elastic.repository;

import com.bootcamp.elastic.dto.request.DateDTO;
import com.bootcamp.elastic.entity.Literature;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.time.LocalDate;
import java.util.List;

public interface LiteratureRepository extends ElasticsearchRepository<Literature, String> {

    List<Literature> findAll();
    List<Literature> findByAuthor(String autor);
    List<Literature> findByEditorial(String editorial);
    List<Literature> findByTitleContains(String title);
    List<Literature> findByCantPagesGreaterThan(Integer pages);
    List<Literature> findByFirstPostBefore(LocalDate date);
    List<Literature> findByFirstPostAfter(LocalDate date);
}




