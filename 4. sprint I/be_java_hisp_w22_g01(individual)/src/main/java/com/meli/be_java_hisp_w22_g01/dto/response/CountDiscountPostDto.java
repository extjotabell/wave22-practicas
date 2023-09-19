package com.meli.be_java_hisp_w22_g01.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountDiscountPostDto {

    private int user_id;
    private String user_name;
    private long promo_products_count;
}
