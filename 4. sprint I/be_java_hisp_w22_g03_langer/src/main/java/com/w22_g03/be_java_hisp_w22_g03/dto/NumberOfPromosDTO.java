package com.w22_g03.be_java_hisp_w22_g03.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class NumberOfPromosDTO {
    private int user_id;
    private String user_name;
    private int promo_products_count;

}
