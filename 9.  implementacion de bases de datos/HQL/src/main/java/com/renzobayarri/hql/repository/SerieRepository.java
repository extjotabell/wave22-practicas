package com.renzobayarri.hql.repository;

import com.renzobayarri.hql.entity.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SerieRepository extends JpaRepository<Serie, Integer> {

    /**
     *
     * @param numberOfSeasons
     * @return todas las series que tengan más de cantidad de temporadas recibida por parámetro
     */
    @Query("FROM Serie s JOIN Season ss ON s = ss.serie WHERE MAX(ss.number) > :numberOfSeasons")
    List<Serie> findAllByMinimumNumberOfSeasons(@Param("numberOfSeasons") int numberOfSeasons);
}