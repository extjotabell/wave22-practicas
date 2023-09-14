package com.w22_g03.be_java_hisp_w22_g03.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {

    @JsonProperty("post_id")
    private long postId;

    @JsonProperty("user_id")
    private long userId;

//    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;

    private ProductDTO product;

    private int category;

    private double price;

    @JsonProperty("has_promo")
    private boolean hasPromo;

    private double discount;
}