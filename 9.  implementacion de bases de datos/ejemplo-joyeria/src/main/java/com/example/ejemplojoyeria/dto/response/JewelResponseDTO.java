package com.example.ejemplojoyeria.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JewelResponseDTO {

    private Long id;
    private String name;
    private String material;
    private int weight;
    private String particularity;
    private boolean hasStone;

}
