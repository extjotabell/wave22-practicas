package com.bootcampW22.EjercicioGlobal.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SpeedAverageDto {
    @NotBlank
    private String brand;

    @NotNull
    private Double average;
}
