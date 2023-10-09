package com.mleiva.relacionesjpa.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter @Setter
public class PersonaKey implements Serializable {
    private Integer dni;
    private Integer numTramite;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonaKey that)) return false;
        return Objects.equals(dni, that.dni) && Objects.equals(numTramite, that.numTramite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni, numTramite);
    }
}
