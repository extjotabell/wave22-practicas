package com.w22_g03.be_java_hisp_w22_g03_bayarri.dto;

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

    @JsonProperty(value = "post_id", index = 0)
    private long postId;

    @JsonProperty(value = "user_id", index = 1)
    @NotNull
    private Long userId;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @JsonProperty(index = 2)
    @NotNull
    private LocalDate date;

    @JsonProperty(index = 3)
    @Valid
    @NotNull
    private ProductDTO product;

    @JsonProperty(index = 4)
    @NotNull
    private Integer category;

    @JsonProperty(index = 5)
    @NotNull
    private Double price;

}