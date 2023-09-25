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

    @JsonProperty(value = "product_id", index = 0)
    @NotNull
    private Long productId;

    @JsonProperty(value = "product_name", index = 1)
    @NotBlank
    private String name;

    @NotBlank
    private String type;

    @NotBlank
    private String brand;

    @NotBlank
    private String color;

    @NotBlank
    private String notes;
}
