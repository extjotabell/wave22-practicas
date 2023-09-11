package com.example.linktracker.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Data;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Link {
    private int id;
    private String url;
    private boolean isValid;
    private int redirectionCount;
    private String password;
}
