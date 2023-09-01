package org;


public class Curriculum extends Documento {

    private long dni;

    private String nombre;

    private String[] habilidades;

    public Curriculum(long dni, String nombre, String[] habilidades) {
        this.dni = dni;
        this.nombre = nombre;
        this.habilidades = habilidades;
    }

    @Override
    public void imprimir() {
        System.out.println("DNI: " + dni);
        System.out.println("Nombre: " + nombre);
        System.out.println("Habilidades: ");
        for (String h : habilidades){
            System.out.println(h);
        }
    }
}
