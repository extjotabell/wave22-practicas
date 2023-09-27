package bootcamp.socialMeli.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown=true)
public class ProductDto {
    @NotNull(message = "El  id no puede estar vacío.")
    @Min(value = 1, message = "El  id debe ser mayor a 0.")
    @JsonProperty("product_id")
    private Integer productId;

    @NotEmpty(message ="El campo no puede estar vacio." )
    @Size(max = 40, message = "La longitud no puede superar los 40 caracteres.")
    @Pattern(regexp = "[a-zA-Z][a-zA-Z ]*", message = "El campo no puede poseer caracteres especiales.")
    @JsonProperty("product_name")
    private String productName;

    @NotEmpty(message = "El campo no puede estar vacio.")
    @Size(max = 15, message = "La longitud no puede superar los 15 caracteres.")
    @Pattern(regexp = "[a-zA-Z][a-zA-Z ]*", message = "El campo no puede poseer caracteres especiales.")
    private String type;

    @NotEmpty(message ="El campo no puede estar vacio." )
    @Size(max = 25, message = "La longitud no puede superar los 25 caracteres.")
    @Pattern(regexp = "[a-zA-Z][a-zA-Z ]*", message = "El campo no puede poseer caracteres especiales.")
    private String brand;

    @NotEmpty(message = "El campo no puede estar vacio.")
    @Size(max = 15, message = "La longitud no puede superar los 15 caracteres.")
    @Pattern(regexp = "[a-zA-Z][a-zA-Z ]*", message = "El campo no puede poseer caracteres especiales.")
    private String color;

    @Size(max=80, message = "La longitud no puede superar los 80 caracteres.")
    @Pattern(regexp = "[a-zA-Z][a-zA-Z ]*", message = "El campo no puede poseer caracteres especiales.")
    private String notes;
}
