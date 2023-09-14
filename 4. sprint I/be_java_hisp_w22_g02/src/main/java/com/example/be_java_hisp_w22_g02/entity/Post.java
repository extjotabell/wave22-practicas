package com.example.be_java_hisp_w22_g02.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    private Long postId;
    private LocalDate date;
    private String category;
    private Double price;
}

