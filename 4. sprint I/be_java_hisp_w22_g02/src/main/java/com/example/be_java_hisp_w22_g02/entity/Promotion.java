package com.example.be_java_hisp_w22_g02.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Promotion extends Post {
    private boolean has_promo;
    private double discount;
}
