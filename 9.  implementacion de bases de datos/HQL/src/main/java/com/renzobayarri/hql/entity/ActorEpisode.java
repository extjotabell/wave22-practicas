package com.renzobayarri.hql.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "actor_episode")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ActorEpisode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP")
    private LocalDateTime createdAt;

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP")
    private LocalDateTime updatedAt;

    @ManyToOne(optional = false)
    @JoinColumn(name = "actor_id", referencedColumnName = "id")
    private Actor actor;

    @ManyToOne(optional = false)
    @JoinColumn(name = "episode_id", referencedColumnName = "id")
    private Episode episode;
}
