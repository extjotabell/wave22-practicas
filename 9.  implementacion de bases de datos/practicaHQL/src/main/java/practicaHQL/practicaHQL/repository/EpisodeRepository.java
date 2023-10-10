package practicaHQL.practicaHQL.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import practicaHQL.practicaHQL.entity.Episode;

import java.util.List;

@Repository
public interface EpisodeRepository extends JpaRepository<Episode,Integer> {
    @Query("select e from Episode e join e.actorEpisodes ep join ep.actor a where (a.firstName like %:actor%) or (a.lastName like %:actor%)")
    List<Episode> allEpisodesByNameActor(@Param("actor") String actor);
}
