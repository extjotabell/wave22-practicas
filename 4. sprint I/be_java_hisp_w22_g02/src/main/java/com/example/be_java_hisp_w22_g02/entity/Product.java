package com.example.be_java_hisp_w22_g02.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private String product_name;
    private String type;
    private String brand;
    private String color;
    private String notes;
}
