package com.w22_g03.be_java_hisp_w22_g03.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDTO {

    @JsonProperty("product_id")
    @NotNull
    private Long productId;

    @JsonProperty("product_name")
    @NotBlank
    private String name;

    private String type;

    private String brand;

    private String color;

    private String notes;
}
