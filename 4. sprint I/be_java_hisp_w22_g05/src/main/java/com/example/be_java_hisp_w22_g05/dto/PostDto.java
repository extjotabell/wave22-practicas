package com.example.be_java_hisp_w22_g05.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@JsonPropertyOrder({"post_id", "user_id", "date", "product", "category","price","has_promo","discount"})
public class PostDto {
    @JsonProperty("post_id")
    private int id;
    @JsonProperty("user_id")
    private int userId;
    private String date;
    private ProductDto product;
    private int category;
    private Double price;
    @JsonProperty("has_promo")
    private Boolean hasPromo;
    private Double discount;
}
