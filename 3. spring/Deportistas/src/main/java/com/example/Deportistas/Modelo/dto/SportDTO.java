package com.example.Deportistas.Modelo.dto;

import com.example.Deportistas.Modelo.Level;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SportDTO {

    private String name;
    @Nullable
    private Level level;
}
