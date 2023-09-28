package com.example.be_java_hisp_w22_g02.dto.request;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostDTO {

    @JsonAlias({"post_id"})
    @NotNull(message = "User id can't be blank/empty")
    @Min(value = 1, message = "User id can't be less than 1")
    private Integer postId;

    @Min(value = 1, message = "User id can't be less than 1")
    @JsonAlias({"user_id"})
    @NotNull(message = "User id can't be blank/empty")
    private Integer userId;

    @NotNull(message = "Date on a post can't be null")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;

    @NotNull(message = "Product can't be null on a post")
    @Valid
    private ProductDto product;

    @Min(value = 1, message = "Category cant be less than 1")
    @NotNull(message = "Category can't be blank or empty")
    private int category;

    @Min(value = 1, message = "Price cant be less than 1")
    @Max(value = 10000000, message = "Price cant be higher than 10000000")
    @NotNull(message = "Price can't be blank or empty")
    private double price;

}
