package org.example.Clases;

import org.example.Interfaces.Imprimible;

public class Curriculum implements Imprimible {

    private String nombre;
    private String apellido;
    private Integer edad;
    private String habilidades;


    public Curriculum(String nombre, String apellido, Integer edad, String habilidades) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.habilidades = habilidades;
    }

    @Override
    public void imprimir() {
        System.out.println("-----------------------------\n" +
                           "-Nombre: "+this.nombre+" "+this.apellido+"\n" +
                           "-Edad: "+this.edad+"\n" +
                           "-Habilidades: "+this.habilidades);
    }
}
