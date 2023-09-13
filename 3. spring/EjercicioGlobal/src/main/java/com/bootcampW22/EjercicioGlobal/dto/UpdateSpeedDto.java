package com.bootcampW22.EjercicioGlobal.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateSpeedDto {
    @NotNull
    private Integer max_speed;
}
