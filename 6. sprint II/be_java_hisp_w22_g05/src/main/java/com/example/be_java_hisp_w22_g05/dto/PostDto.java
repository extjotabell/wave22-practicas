package com.example.be_java_hisp_w22_g05.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.Valid;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PostDto {
    @JsonProperty("post_id")
    private int id;
    @NotNull(message = "El id no puede estar vacio")
    @Min(value = 1,message = "El id debe ser mayor a 0")
    @JsonProperty("user_id")
    private int userId;
    @NotBlank(message = "La fecha no puede estar vacia")
    private String date;
    private @Valid ProductDto product;
    @NotNull(message = "El campo no puede estar vacio")
    private int category;
    @NotNull(message = "El campo no puede estar vacio")
    @DecimalMax(value = "10000000", message = "El precio maximo por producto no puede ser mayor a 10.000.000")
    private Double price;
    @JsonProperty("has_promo")
    private Boolean hasPromo;
    private Double discount;
}
