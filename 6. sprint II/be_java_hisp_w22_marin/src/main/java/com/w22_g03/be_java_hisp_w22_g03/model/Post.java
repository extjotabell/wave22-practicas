package com.w22_g03.be_java_hisp_w22_g03.model;

import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode
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
