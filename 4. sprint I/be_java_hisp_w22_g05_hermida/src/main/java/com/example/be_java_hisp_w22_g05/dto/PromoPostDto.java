package com.example.be_java_hisp_w22_g05.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PromoPostDto {

    @JsonProperty("user_id")
    private int id;

    @JsonProperty("user_name")
    private String username;

    @JsonProperty("promo_products_count")
    private int promoProductsCount;
}
