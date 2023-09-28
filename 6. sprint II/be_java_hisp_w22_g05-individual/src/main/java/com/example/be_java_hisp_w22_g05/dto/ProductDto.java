package com.example.be_java_hisp_w22_g05.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductDto {
    @JsonProperty("product_id")
    @Min(value = 1,message = "El id debe ser mayor a 0")
    private int id;
    @JsonProperty("product_name")
    @NotBlank(message = "El campo no puede estar vacio")
    @Size(max = 40, message = "La longitud no puede superar los 40 caracteres")
    @Pattern(regexp = "^[a-zA-Z0-9\\s]*$", message = "El campo no puede poseer caracteres especiales")
    private String name;
    @NotBlank(message = "El campo no puede estar vacio")
    @Size(max = 15, message = "La longitud no puede superar los 15 caracteres")
    @Pattern(regexp = "^[a-zA-Z0-9\\s]*$", message = "El campo no puede poseer caracteres especiales")
    private String type;
    @NotBlank(message = "El campo no puede estar vacio")
    @Size(max = 25, message = "La longitud no puede superar los 25 caracteres")
    @Pattern(regexp = "^[a-zA-Z0-9\\s]*$", message = "El campo no puede poseer caracteres especiales")
    private String brand;
    @NotBlank(message = "El campo no puede estar vacio")
    @Size(max = 15, message = "La longitud no puede superar los 15 caracteres")
    @Pattern(regexp = "^[a-zA-Z0-9\\s]*$", message = "El campo no puede poseer caracteres especiales")
    private String color;
    @Size(max = 80, message = "La longitud no puede superar los 80 caracteres")
    @Pattern(regexp = "^[a-zA-Z0-9\\s]*$", message = "El campo no puede poseer caracteres especiales")
    private String notes;
}
