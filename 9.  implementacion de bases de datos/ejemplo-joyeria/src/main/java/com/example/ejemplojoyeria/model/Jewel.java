package com.example.ejemplojoyeria.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Setter
@Getter
@SQLDelete(sql = "UPDATE jewel SET sell_or_not = false WHERE id=?")
@Where(clause = "sell_or_not=true")
public class Jewel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String material;
    private int weight;
    private String particularity;
    private boolean hasStone;
    private boolean sellOrNot = Boolean.TRUE;
}
