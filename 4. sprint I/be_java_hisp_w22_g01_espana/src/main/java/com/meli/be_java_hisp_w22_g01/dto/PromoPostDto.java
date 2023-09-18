package com.meli.be_java_hisp_w22_g01.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PromoPostDto {
    private int user_id;
    private LocalDate date;
    private ProductDto product;
    private int category;
    private double price;
    private boolean has_promo;
    private double discount;
}
