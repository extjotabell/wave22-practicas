package com.example.LinkTracker.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.bind.DefaultValue;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Link {
    private int id;
    private String url;
    private String password;
    private boolean isActive;
    private int visits;
}