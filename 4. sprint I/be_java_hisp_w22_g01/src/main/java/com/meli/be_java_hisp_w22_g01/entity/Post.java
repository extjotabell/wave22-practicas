package com.meli.be_java_hisp_w22_g01.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    private int user_id;
    private int post_id;
    private LocalDate date;
    private Product product;
    private int category;
    private double price;
}
