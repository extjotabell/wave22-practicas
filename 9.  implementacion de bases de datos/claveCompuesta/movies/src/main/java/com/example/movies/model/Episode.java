package com.example.movies.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "episodes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Episode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    private String title;

    private int number;

    @Column(name = "release_date")
    private Date releaseDate;

    private double rating;

    @Column(name = "season_id")
    private int seasonId;

    @ManyToMany(mappedBy = "episodes")
    private Set<Actor> actors;

}
