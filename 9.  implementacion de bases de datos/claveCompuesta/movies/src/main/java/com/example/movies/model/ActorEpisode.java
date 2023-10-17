package com.example.movies.model;

import jakarta.persistence.*;
import lombok.*;

import java.security.Timestamp;

@Entity
@Table(name = "actor_episode")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ActorEpisode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @Column(name = "actor_id")
    private int actorId;

    @Column(name = "episode_id")
    private int episodeId;
}
