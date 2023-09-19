package com.example.be_java_hisp_w22_g02.dto.response;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostPromoByUserDTO {

    @JsonAlias("user_id")
    private int userId;
    @JsonAlias("user_name")
    private String userName;
    @JsonAlias("promo_products_count")
    private int promoProductsCount;

}