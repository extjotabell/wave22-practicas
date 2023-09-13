package com.bootcampW22.EjercicioGlobal.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VehicleDto {
    @NotNull
    private Long id;

    @NotBlank
    private String brand;

    @NotBlank
    private String model;

    @NotBlank
    private String registration;

    @NotBlank
    private String color;

    @NotNull
    private Integer year;

    @NotBlank
    private String max_speed;

    @NotNull
    private Integer passengers;

    @NotBlank
    private String fuel_type;

    @NotBlank
    private String transmission;

    @NotNull
    private Double height;

    @NotNull
    private Double width;

    @NotNull
    private Double weight;

    public boolean verifyFields() {
        return id != null && id > 0 &&
                (brand == null || !brand.isEmpty()) &&
                (model == null || !model.isEmpty()) &&
                (registration == null || !registration.isEmpty()) &&
                (color == null || !color.isEmpty()) &&
                year != null && year > 0 &&
                (max_speed == null || !max_speed.isEmpty()) &&
                passengers != null && passengers > 0 &&
                (fuel_type == null || !fuel_type.isEmpty()) &&
                (transmission == null || !transmission.isEmpty()) &&
                height != null && height >= 0 &&
                width != null && width >= 0 &&
                weight != null && weight >= 0;
    }
}
