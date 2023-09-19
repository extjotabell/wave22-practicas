package com.meli.be_java_hisp_w22_g01.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class PostDto {
    private int user_id;
    private int post_id;
    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate date;
    private ProductDto product;
    private int category;
    private double price;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private PostPromoDTO promo;

    public PostDto(int user_id, int post_id, LocalDate date, ProductDto product, int category, double price) {
        this.user_id = user_id;
        this.post_id = post_id;
        this.date = date;
        this.product = product;
        this.category = category;
        this.price = price;
    }

    public PostDto(int user_id, int post_id, LocalDate date, ProductDto product, int category, double price, PostPromoDTO promo) {
        this.user_id = user_id;
        this.post_id = post_id;
        this.date = date;
        this.product = product;
        this.category = category;
        this.price = price;
        this.promo = promo;
    }
}

