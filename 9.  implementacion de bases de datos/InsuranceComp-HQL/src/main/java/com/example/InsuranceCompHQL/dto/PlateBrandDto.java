package com.example.InsuranceCompHQL.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.repository.query.Param;

@Data
@AllArgsConstructor
public class PlateBrandDto {
    private String plate;
    private String brand;
}
