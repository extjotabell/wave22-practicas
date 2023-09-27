package com.example.be_java_hisp_w22_g02.dto.request;

import com.example.be_java_hisp_w22_g02.entity.Product;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
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
    @Max(100)
    @JsonAlias({"user_id"})
    @NotNull(message = "User id can't be blank/empty")
    private Integer userId;

    @NotNull
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;

    @NotNull
    private ProductDto product;

    @Min(1)
    @Max(100)
    @NotNull(message = "Category can't be blank or empty")
    private int category;

    @Min(1)
    @Max(10000000)
    @NotNull(message = "Price can't be blank or empty")
    private double price;
}
