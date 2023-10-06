package com.example.joya.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown=true)
public class JewerlyDto {
        private String nombre;
        private String material;
        private Double peso;
        private String particularidad;
        @JsonProperty("posee_piedra")
        private Boolean poseePiedra;
        private Boolean ventaONo;


}
