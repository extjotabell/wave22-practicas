package com.example.ejerciciocalculadoracalorias2.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DishRequestDTO {

    private String name;
    private List<String> ingredients;
    private int weight;

}
