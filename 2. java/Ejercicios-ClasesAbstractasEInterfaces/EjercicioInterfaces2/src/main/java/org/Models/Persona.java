package org.Models;

import java.util.ArrayList;
import java.util.List;

public class Persona {
    private String nombre;
    private int dni;
    private List<Skill> personaSkill;

    public Persona(String nombre, int dni, List<Skill> personaSkill) {
        this.nombre = nombre;
        this.dni = dni;
        this.personaSkill = personaSkill;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public List<Skill> getPersonaSkill() {
        return personaSkill;
    }

    public void setPersonaSkill(List<Skill> personaSkill) {
        this.personaSkill = personaSkill;
    }
}
