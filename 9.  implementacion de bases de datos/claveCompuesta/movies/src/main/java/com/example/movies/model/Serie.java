package com.example.movies.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "series")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Serie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    @Column(length = 500)
    private String title;

    @Column(name = "release_date")
    private Date releaseDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "genre_id")
    private int genreId;
}