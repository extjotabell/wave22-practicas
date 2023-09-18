package com.example.be_java_hisp_w22_g02.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    private int postId;
    private int user_id;
    private LocalDate date;
    private Product product;
    private int category;
    private double price;
}

