package com.w22_g03.be_java_hisp_w22_g03.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.w22_g03.be_java_hisp_w22_g03.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NumberOfPromoProductsDTO {

    @JsonProperty("user_id")
    private Long userId;

    @JsonProperty("user_name")
    private String userName;

    @JsonProperty("promo_products_count")
    private int promoProductsCount;

    public static NumberOfPromoProductsDTO buildNumberOfPromoProductsDTO(User user, int promoProductsCount){
        return NumberOfPromoProductsDTO.builder()
                .userId(user.getUserId())
                .userName(user.getUsername())
                .promoProductsCount(promoProductsCount)
                .build();
    }
}
