package com.w22_g03.be_java_hisp_w22_g03.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {

    @JsonProperty("post_id")
    private long postId;

    @JsonProperty("user_id")
    @NotNull
    private Long userId;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @NotNull
    private LocalDate date;

    @Valid
    @NotNull
    private ProductDTO product;

    @NotNull
    private Integer category;

    @NotNull
    private Double price;

    private boolean hasPromo;

    private double discount;

}