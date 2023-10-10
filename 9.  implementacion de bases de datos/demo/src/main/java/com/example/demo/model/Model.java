package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Model {
    @Id
    @GeneratedValue()
    Long id;
    String name;
    Double rating;
    int amount_of_awards;
}
