package com.example.be_java_hisp_w22_g02.dto.request;

import com.example.be_java_hisp_w22_g02.entity.Product;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {
    @Min(1)
    @Max(100)
    @JsonAlias({"user_id"})
    private int userId;
    @NotNull
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
    @NotNull
    private ProductDto product;
    @Min(1)
    @Max(100)
    private int category;
    @DecimalMin("1.0")
    private double price;
}
