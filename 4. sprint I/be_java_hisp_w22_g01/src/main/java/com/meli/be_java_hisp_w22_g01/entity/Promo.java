package com.meli.be_java_hisp_w22_g01.entity;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Promo extends Post {
    private boolean has_promo;
    private double discount;
}
