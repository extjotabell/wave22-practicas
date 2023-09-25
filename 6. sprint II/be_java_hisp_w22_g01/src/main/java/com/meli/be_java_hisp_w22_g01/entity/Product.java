package com.meli.be_java_hisp_w22_g01.entity;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Product {

    private int product_id;
    private String product_name;
    private String type;
    private String brand;
    private String color;
    private String notes;
}
