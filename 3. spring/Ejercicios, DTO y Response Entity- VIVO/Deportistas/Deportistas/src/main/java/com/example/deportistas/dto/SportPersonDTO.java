package com.example.deportistas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SportPersonDTO {
    private String name;
    private String lastname;

    private String sportName;
}
