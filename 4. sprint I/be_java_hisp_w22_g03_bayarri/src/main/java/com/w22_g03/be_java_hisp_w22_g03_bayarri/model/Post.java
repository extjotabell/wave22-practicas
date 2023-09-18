package com.w22_g03.be_java_hisp_w22_g03_bayarri.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Post {

    private long postId;

    private User user;

    private LocalDate date;

    private Product product;

    private int category;

    private double price;

    private boolean hasPromo;

    private double discount;

}
