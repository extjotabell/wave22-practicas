package com.ejercicios.linktracker.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Link {
    private Integer linkId;
    private String url;
    private Boolean isActive;
    private Integer count;
    private String password;
}
