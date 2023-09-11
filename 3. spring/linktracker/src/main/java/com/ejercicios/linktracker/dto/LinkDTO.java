package com.ejercicios.linktracker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LinkDTO {

    private int linkId;
    private String url;
    private Integer count;
    private String password;

}
