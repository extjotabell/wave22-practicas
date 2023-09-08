package com.calculadoraCalorias.CalculadoraCalorias.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Food {
    private String name;
    private int calories;
    private int weigth;

    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                ", calories=" + calories +
                ", weigth=" + weigth +
                '}';
    }
}
