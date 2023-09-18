package com.meli.be_java_hisp_w22_g01.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountPromotionsDTO {
    private int user_id;
    private String user_name;
    private int promo_products_count;
}