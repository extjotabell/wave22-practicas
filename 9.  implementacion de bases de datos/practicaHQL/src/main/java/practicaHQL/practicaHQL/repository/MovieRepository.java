package practicaHQL.practicaHQL.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import practicaHQL.practicaHQL.entity.Movie;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Integer> {
    @Query("select m from Movie m where m.rating > :rating")
    List<Movie> allMoviesWithRatingMoreThan(@Param("rating") double rating);
    @Query("select m from Movie m join m.genre gm where gm.name like :genre")
    List<Movie> allMoviesByGenre(@Param("genre") String genre);
}
