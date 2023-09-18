package com.w22_g03.be_java_hisp_w22_g03.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SellerPromotionsCountDTO {
    @JsonProperty("user_id")
    private Long userId;

    @JsonProperty("user_name")
    private String username;

    @JsonProperty("promo_products_count")
    private Long promoProductsCount;

}
