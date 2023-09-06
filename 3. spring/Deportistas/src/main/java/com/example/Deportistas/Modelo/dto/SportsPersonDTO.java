package com.example.Deportistas.Modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SportsPersonDTO {
    private String fullName;
    private List<SportDTO> sports;
}
