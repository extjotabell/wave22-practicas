package com.miniseries.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class MiniSerie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double rating;

    @Column(name = "amount_of_awards")
    private int amountOFAwards;

}
