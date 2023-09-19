package com.meli.be_java_hisp_w22_g01.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PromoDTO extends PostDto{
    private boolean has_promo;
    private double discount;
}
