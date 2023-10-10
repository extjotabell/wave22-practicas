package com.example.InsuranceCompHQL.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "vehicles")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;
    private String plate;
    private String brand;
    private String model;
    private Integer fabricationYear;
    private Integer wheels;
    @OneToMany(mappedBy = "vehicle")
    private List<Accident> accidentList = new ArrayList<>();

}
