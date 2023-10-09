package com.bootcamp.elastic.repository;

import com.bootcamp.elastic.entity.Literature;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.time.LocalDate;
import java.util.List;

public interface LiteratureRepository extends ElasticsearchRepository<Literature, String> {
/*    @Override
    List<Literature> findAll();*/

    List<Literature> findByAuthor(String author);
    List<Literature> findByTitleContains(String title);
    List<Literature> findByCantPagesGreaterThan(Integer pages);
    List<Literature> findByFirstPostBefore(LocalDate date);
    List<Literature> findByFirstPostAfter(LocalDate date);
    List<Literature> findByEditorial(String editorial);
}
