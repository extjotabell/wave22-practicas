package com.example.be_java_hisp_w22_g05.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@JsonPropertyOrder({"user_id", "user_name", "promo_products_count"})
public class PostPromoCountDto {

    @JsonProperty("user_id")
    private int userId;
    @JsonProperty("user_name")
    private String userName;
    @JsonProperty("promo_products_count")
    private int promoProductsCount;

}
