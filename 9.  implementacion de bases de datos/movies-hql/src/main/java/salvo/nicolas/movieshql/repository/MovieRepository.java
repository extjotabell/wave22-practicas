package salvo.nicolas.movieshql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import salvo.nicolas.movieshql.model.Actor;
import salvo.nicolas.movieshql.model.Movie;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

    @Query("""
        SELECT m FROM Movie m
        JOIN FETCH m.actors ma
        WHERE ma.rating >= ?1
    """)
    List<Movie> findMoviesThatActorsHaveRankingGreaterThan(Double rating);

    @Query("""
        SELECT m FROM Movie m
        WHERE m.genre.id = ?1
    """)
    List<Movie> findMoviesThatGenreIs(Integer id);

}
