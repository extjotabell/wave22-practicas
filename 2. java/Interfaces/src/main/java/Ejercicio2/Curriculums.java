package Ejercicio2;

import java.sql.Array;
import java.util.Arrays;

public class Curriculums implements Imprimible{
    private String nombre;
    private String edad;
    private String profesion;
    private String habilidades [] = new String[3];

    public Curriculums(String nombre, String edad, String profesion, String[] habilidades) {
        this.nombre = nombre;
        this.edad = edad;
        this.profesion = profesion;
        this.habilidades = habilidades;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String[] getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(String[] habilidades) {
        this.habilidades = habilidades;
    }

    @Override
    public String toString() {
        return "Curriculums{" +
                "nombre='" + nombre + '\'' +
                ", edad='" + edad + '\'' +
                ", profesion='" + profesion + '\'' +
                ", habilidades=" + Arrays.toString(habilidades) +
                '}';
    }

    @Override
    public void imprimir() {
        System.out.println("Imprimir " + toString());
    }
}
