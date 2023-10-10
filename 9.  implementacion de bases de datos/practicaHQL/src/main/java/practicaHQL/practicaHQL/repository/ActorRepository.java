package practicaHQL.practicaHQL.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import practicaHQL.practicaHQL.entity.Actor;

import java.util.List;

@Repository
public interface ActorRepository extends JpaRepository<Actor,Integer> {

    @Query("select a from Actor a where a.movie is not null")
    List<Actor> allActorsWithFavoriteMovie();
    @Query("select a from Actor a where a.rating > :rating")
    List<Actor> allActorsWithRatingMoreThan(@Param("rating") double rating);
    @Query("select a from Actor a join a.actorMovies am join am.movie m where m.title like %:movie%")
    List<Actor> allActorsWorkInMovie(@Param("movie") String movie);
}
