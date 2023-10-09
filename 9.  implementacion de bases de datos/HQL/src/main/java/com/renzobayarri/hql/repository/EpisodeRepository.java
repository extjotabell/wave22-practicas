package com.renzobayarri.hql.repository;

import com.renzobayarri.hql.entity.Episode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EpisodeRepository extends JpaRepository<Episode, Integer> {


    /**
     * @param lastName of the actor
     * @return todos los episodios (de cualquier serie) donde trabaja un actor recibido por parámetro
     */
    @Query("FROM Episode e JOIN ActorEpisode ae ON e = AE.actor WHERE ae.actor.lastName = :lastName")
    List<Episode> findAllByActorLastName(@Param("lastName") String lastName);
}