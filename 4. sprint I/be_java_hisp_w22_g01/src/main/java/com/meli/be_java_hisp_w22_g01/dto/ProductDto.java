package com.meli.be_java_hisp_w22_g01.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private int product_id;
    private String product_name;
    private String type;
    private String brand;
    private String color;
    private String notes;
}
