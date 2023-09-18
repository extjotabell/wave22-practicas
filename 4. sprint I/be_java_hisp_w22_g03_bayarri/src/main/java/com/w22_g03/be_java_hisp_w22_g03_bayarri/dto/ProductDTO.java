package com.w22_g03.be_java_hisp_w22_g03_bayarri.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

    @JsonProperty(index = 2)
    @NotBlank
    private String type;

    @JsonProperty(index = 3)
    @NotBlank
    private String brand;

    @JsonProperty(index = 4)
    @NotBlank
    private String color;

    @JsonProperty(index = 5)
    @NotBlank
    private String notes;
}
