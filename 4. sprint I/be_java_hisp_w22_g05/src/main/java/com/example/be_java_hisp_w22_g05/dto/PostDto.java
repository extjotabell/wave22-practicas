package com.example.be_java_hisp_w22_g05.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostDto {
    @JsonProperty("post_id")
    private int id;
    @JsonProperty("user_id")
    private int userId;
    private LocalDate date;
    private ProductDto product;
    private int category;
    private Double price;
}
