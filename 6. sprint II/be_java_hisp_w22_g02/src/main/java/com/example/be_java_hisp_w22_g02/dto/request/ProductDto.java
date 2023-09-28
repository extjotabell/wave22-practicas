package com.example.be_java_hisp_w22_g02.dto.request;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {
    @Min(value = 1, message = "Product Id can't be less than 1")
    @JsonAlias({"product_id"})
    @NotNull(message = "Product id can't be blank or empty.")
    private int productId;

    @NotNull(message = "Product name can't be blank or empty.")
    @JsonAlias({"product_name"})
    @Size(max = 40, message = "Product names can have 40 characters MAX.")
    @Pattern(regexp = "^[A-Za-z ]*$", message = "Special characters are not allowed.")
    private String productName;

    @NotNull(message = "Type of a product can't be null or empty")
    @Size(max = 15, message = "Product names can have 15 characters MAX.")
    @Pattern(regexp = "^[A-Za-z]*$", message = "Special characters are not allowed or blank spaces.")
    private String type;

    @NotNull(message = "Brand of a product can't be null or empty")
    private String brand;

    @NotNull(message = "Color of a product can't be null or empty")
    @Size(max = 15, message = "Product names can have 15 characters MAX.")
    @Pattern(regexp = "^[A-Za-z]*$", message = "Special characters are not allowed or blank spaces.")
    private String color;

    @Size(max = 80, message = "Product names can have 80 characters MAX.")
    @Pattern(regexp = "^[A-Za-z ]*$", message = "Special characters are not allowed.")
    private String notes;
}
