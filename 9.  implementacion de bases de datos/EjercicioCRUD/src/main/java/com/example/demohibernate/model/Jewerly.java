package com.example.demohibernate.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Jewerly {

    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    private Long indentifyNumber;
    private String name;
    private String material;
    private double weight;
    private String particularity;
    private boolean hasStone;
    private boolean isOnSale = true;
}
