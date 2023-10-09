package com.example.demohibernate.dto;

import lombok.*;

@Setter @Getter
@Data @AllArgsConstructor @NoArgsConstructor
public class JewerlyDto {
    private String name;
    private String material;
    private double weight;
    private String particularity;
    private boolean hasStone;
}
