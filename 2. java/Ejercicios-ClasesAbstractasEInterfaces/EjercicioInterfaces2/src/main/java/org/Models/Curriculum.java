package org.Models;

import java.util.stream.Collectors;

public class Curriculum extends Documento {
    private Persona persona;

    public Curriculum(String autor, Persona persona) {
        super(autor);
        this.persona = persona;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @Override
    public String toString() {
        return "Curriculum{" +
                "nombre ='" + persona.getNombre() + '\'' +
                ", dni =" + persona.getDni() +
                ", skills =" + persona.getPersonaSkill().stream().map(Skill::toString).collect(Collectors.toList()) +
                '}';
    }

    @Override
    public void imprimirDocumento()
    {
        super.imprimirDocumento();
        System.out.println(toString());
    }
}
