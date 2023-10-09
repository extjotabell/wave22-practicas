package com.meli.practicaasynchql.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "genres")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String name;
    private Integer ranking;
    private Boolean active;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id", nullable = false)
    private List<Movie> movies;


}
