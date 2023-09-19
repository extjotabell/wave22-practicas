package com.example.be_java_hisp_w22_g05.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@JsonPropertyOrder({"product_id", "product_name", "name", "type", "brand","color","notes"})
public class ProductDto {
    @JsonProperty("product_id")
    private int id;
    @JsonProperty("product_name")
    private String name;
    private String type;
    private String brand;
    private String color;
    private String notes;
}
