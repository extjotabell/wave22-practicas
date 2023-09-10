package com.example.Covid19.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Patient {
    private int id;
    private String name;
    private String lastName;
    private  int age;
    private List<Symptom> symptomList;

}
