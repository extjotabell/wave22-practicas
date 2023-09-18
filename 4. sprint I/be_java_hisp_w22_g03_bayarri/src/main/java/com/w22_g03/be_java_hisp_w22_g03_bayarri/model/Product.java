package com.w22_g03.be_java_hisp_w22_g03_bayarri.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {

    private long productId;

    private String productName;

    private String type;

    private String brand;

    private String color;

    private String notes;

    private Post post;
}
