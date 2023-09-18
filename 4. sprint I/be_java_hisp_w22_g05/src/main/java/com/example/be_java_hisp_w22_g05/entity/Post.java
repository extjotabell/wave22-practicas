package com.example.be_java_hisp_w22_g05.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Post {
    private int id;
    private LocalDate date;
    private int category;
    private User user;
    private Product product;
    private Double price;
    private Boolean hasPromo;
    private Double discount;
}
