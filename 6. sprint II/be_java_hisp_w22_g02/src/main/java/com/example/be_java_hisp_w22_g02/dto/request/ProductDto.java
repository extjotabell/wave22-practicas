package com.example.be_java_hisp_w22_g02.dto.request;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    @Min(1)
    @JsonAlias({"product_id"})
    @NotNull(message = "Product id can't be blank or empty.")
    private int productId;

    @NotNull(message = "Product name can't be blank or empty.")
    @JsonAlias({"product_name"})
    @Size(max = 40, message = "Product names can have 40 characters MAX.")
    @Pattern(regexp = "^[A-Z][a-z]\\s*$", message = "Special characters are not allowed.")
    private String productName;

    @NotNull
    @Size(max = 15, message = "Product names can have 15 characters MAX.")
    @Pattern(regexp = "^[a-z][A-Z]*$", message = "Special characters are not allowed.")
    private String type;

    @NotNull
    private String brand;

    @NotNull
    @Size(max = 15, message = "Product names can have 15 characters MAX.")
    @Pattern(regexp = "^[a-z][A-Z]*$", message = "Special characters are not allowed.")
    private String color;

    @NotNull
    @Size(max = 80, message = "Product names can have 80 characters MAX.")
    @Pattern(regexp = "^[A-Z][a-z]\\s*$", message = "Special characters are not allowed.")
    private String notes;
}
