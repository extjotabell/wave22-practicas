package com.bootcamp.elastic.repository;

import com.bootcamp.elastic.entity.Literature;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface LiteratureRepository extends ElasticsearchRepository<Literature, String> {
    List<Literature> findAllByAuthor(String author);
    List<Literature> findAllByNameContains(String title);
    List<Literature> findAllByPagesGreaterThan(int pages);
    List<Literature> findAllByFirstPublicationYearGreaterThan(int year);
    List<Literature> findAllByFirstPublicationYearLessThan(int year);
    List<Literature> findAllByPublisher(String publisher);

}
