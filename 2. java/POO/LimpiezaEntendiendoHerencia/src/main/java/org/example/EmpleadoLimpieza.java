package org.example;

public class EmpleadoLimpieza {
    private int legajo;
    private String nombre;
    public void limpiar(Aspiradora aspiradora){
        System.out.println(aspiradora.aspirar());
    }

    public EmpleadoLimpieza(int legajo, String nombre) {
        this.legajo = legajo;
        this.nombre = nombre;
    }
}
