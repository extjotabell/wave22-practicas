package com.meli.be_java_hisp_w22_g01.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class OffertPost extends Post{
    private Boolean has_promo;
    private double discount;
}
