package com.w22_g03.be_java_hisp_w22_g03.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Product {

    private long productId;

    private String productName;

    private String type;

    private String brand;

    private String color;

    private String notes;

    private Post post;
}
