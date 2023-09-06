package com.covid19.covid19.DTO;

import java.io.Serializable;

public class PersonaDTO implements Serializable {
    private String fullName;
    private int edad;
    private String sintoma;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSintoma() {
        return sintoma;
    }

    public void setSintoma(String sintoma) {
        this.sintoma = sintoma;
    }

    @Override
    public String toString() {
        return "PersonaDTO{" +
                "fullName='" + fullName + '\'' +
                ", edad=" + edad +
                ", sintoma='" + sintoma + '\'' +
                '}';
    }
}
