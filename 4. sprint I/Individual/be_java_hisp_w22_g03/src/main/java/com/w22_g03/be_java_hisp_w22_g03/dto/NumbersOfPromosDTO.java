package com.w22_g03.be_java_hisp_w22_g03.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NumbersOfPromosDTO {
    long user_id;
    String user_name;
    int promo_products_count;
}
