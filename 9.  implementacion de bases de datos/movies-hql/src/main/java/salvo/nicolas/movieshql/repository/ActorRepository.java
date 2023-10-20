package salvo.nicolas.movieshql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import salvo.nicolas.movieshql.model.Actor;

import java.util.List;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Integer> {
    List<Actor> findAllByMoviesIsNotNull();

    List<Actor> findAllByRatingIsGreaterThan(Double rating);

    @Query(value = """
        SELECT *
        FROM actors a
        WHERE a.favorite_movie_id = ?1
    """, nativeQuery = true)
    List<Actor> findAllByMoviesContains(Integer movieId);
}
