package com.gym.deportistas.models.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.gym.deportistas.models.Level;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SportDTO {
    String name;
    Level level;
}
