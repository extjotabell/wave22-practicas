package com.example.ejemplojoyeria.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JewelRequestDTO {

    private String name;
    private String material;
    private int weight;
    private String particularity;
    private boolean hasStone;

}
