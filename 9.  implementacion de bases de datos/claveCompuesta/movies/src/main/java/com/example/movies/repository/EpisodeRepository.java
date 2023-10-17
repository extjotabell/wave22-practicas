package com.example.movies.repository;

import com.example.movies.model.Episode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EpisodeRepository extends JpaRepository<Episode, Integer> {
    @Query("SELECT e FROM Episode e JOIN e.actors a WHERE a.id = :actorId")
    List<Episode> findEpisodesWhereActorWorks(@Param("actorId") Integer actorId);
}