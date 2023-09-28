package com.w22_g03.be_java_hisp_w22_g03.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {

    @JsonProperty(value = "post_id", index = 1)
    @Null(message = "Id no debe incluirse")
    private Long postId;

    @JsonProperty(value = "user_id", index = 0)
    @NotNull(message = "El  id no puede estar vacío.")
    @Min(value = 1, message = "El id debe ser mayor a cero")
    private Long userId;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @JsonProperty(index = 2)
    @NotNull(message = "La fecha no puede estar vacía.")
    private LocalDate date;

    @Valid
    @NotNull
    @JsonProperty(index = 3)
    private ProductDTO product;

    @NotNull(message = "El campo no puede estar vacío")
    @JsonProperty(index = 4)
    private Integer category;

    @NotNull(message = "El campo no puede estar vacío")
    @Max(value = 10000000, message = "El precio máximo por producto es de 10.000.000")
    private Double price;

}