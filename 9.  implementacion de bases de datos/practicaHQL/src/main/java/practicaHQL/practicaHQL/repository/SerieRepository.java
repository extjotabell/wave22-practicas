package practicaHQL.practicaHQL.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import practicaHQL.practicaHQL.entity.Serie;

import java.util.List;

@Repository
public interface SerieRepository extends JpaRepository<Serie,Integer> {
    @Query("select s from Serie s join s.seasons se where se.number > :number_seasons")
    List<Serie> allSeriesWithMoreSeasonsThan(@Param("number_seasons") int number_seasons);
}
