package com.example.be_java_hisp_w22_g02.entity;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @JsonAlias({"product_id"})
    private int productId;
    @JsonAlias({"user_id"})
    private String productName;
    private String type;
    private String brand;
    private String color;
    private String notes;
}
