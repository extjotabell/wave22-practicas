package com.renzobayarri.obrasliterarias.repository;

import com.renzobayarri.obrasliterarias.entity.ObraLiteraria;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IObraLiterariaRepository extends ElasticsearchRepository<ObraLiteraria, String> {

    //    Retornar las obras de un autor dado por el usuario.
    List<ObraLiteraria> findAllByAuthor(String author);

    //    Retornar las obras que contengan palabras dadas por el usuario en sus títulos.
    List<ObraLiteraria> findAllByNameContains(String title);

    //    Retornar las obras con más cantidad de páginas que las indicadas por el usuario.
    List<ObraLiteraria> findAllByPagesGreaterThan(int pages);

    //    Retornar las obras que fueron publicadas antes y después de un año dado por el usuario (crear 2 endpoints).
    List<ObraLiteraria> findAllByFirstPublicationYearGreaterThan(int year);

    List<ObraLiteraria> findAllByFirstPublicationYearLessThan(int year);

    //    Retornar las obras de una misma editorial.
    List<ObraLiteraria> findAllByPublisher(String publisher);

}
