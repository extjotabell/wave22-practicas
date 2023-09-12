package com.example.linktracker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class LinkDTO {
    private int id;
    private String url;
    private Boolean isValid;
    private int redirectionCount;
    private String password;
}
