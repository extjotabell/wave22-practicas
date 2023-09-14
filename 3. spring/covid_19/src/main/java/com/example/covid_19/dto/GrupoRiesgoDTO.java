package com.example.covid_19.dto;

import java.util.ArrayList;
import java.util.List;

public class GrupoRiesgoDTO {
    List<PersonaDTO> grupoRiesgo;

    public GrupoRiesgoDTO() {
        this.grupoRiesgo = new ArrayList<>();
    }

    public List<PersonaDTO> getGrupoRiesgo() {
        return grupoRiesgo;
    }

    public void setGrupoRiesgo(List<PersonaDTO> grupoRiesgo) {
        this.grupoRiesgo = grupoRiesgo;
    }
}
