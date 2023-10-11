package com.example.showroom.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClothesDTO {
    @JsonIgnore
    private Long id;
    private String code;
    private String name;
    private String type;
    private String brand;
    private String color;
    private String size;
    private int amount;
    private double price;
}
