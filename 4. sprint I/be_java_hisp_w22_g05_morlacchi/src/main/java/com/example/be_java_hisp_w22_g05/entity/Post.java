package com.example.be_java_hisp_w22_g05.entity;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Data
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
