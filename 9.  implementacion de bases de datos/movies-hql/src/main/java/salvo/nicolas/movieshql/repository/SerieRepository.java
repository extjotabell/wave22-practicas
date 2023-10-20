package salvo.nicolas.movieshql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import salvo.nicolas.movieshql.model.Movie;
import salvo.nicolas.movieshql.model.Serie;

import java.util.List;

@Repository
public interface SerieRepository extends JpaRepository<Serie, Integer> {
    @Query("""
        SELECT s.serie FROM Season s
        WHERE s.number > ?1
    """)
    List<Serie> findSeriesThatSeasonsGreaterThan(Integer seasonsNumber);
}
