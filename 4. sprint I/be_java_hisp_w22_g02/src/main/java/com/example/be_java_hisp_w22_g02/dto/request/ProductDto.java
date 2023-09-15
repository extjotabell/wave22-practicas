package com.example.be_java_hisp_w22_g02.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    @Min(0)
    private int product_id;
    @NotNull
    private String product_name;
    @NotNull
    private String type;
    @NotNull
    private String brand;
    @NotNull
    private String color;
    @NotNull
    private String notes;
}
