package salvo.nicolas.movieshql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import salvo.nicolas.movieshql.model.Episode;

import java.util.List;

@Repository
public interface EpisodeRepository extends JpaRepository<Episode, Integer> {
    @Query(value = """
        SELECT e
        FROM Episode e
        JOIN FETCH e.actors a
        WHERE a.id = ?1
    """)
//    @Query(value = """
//    SELECT * FROM episodes e
//    JOIN actor_episode ae ON e.id = ae.episode_id
//    WHERE ae.actor_id = ?1
//    """, nativeQuery = true)
//    @Query("""
//        SELECT a.episodes
//        FROM Actor a
//        WHERE a.id = ?1
//    """)
    List<Episode> findEpisodesByActorId(Integer actorId);
}
