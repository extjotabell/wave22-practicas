package org.example;

public abstract class Mascota {
    private String nombre;
    private String color;
    private String especie;


    public Mascota(String nombre, String color, String especie) {
        this.nombre = nombre;
        this.color = color;
        this.especie = especie;
    }

    public Mascota() {
    }

    public void comer(){
        System.out.println("Comiendo...");
    }

    public  void  jugar(){
        System.out.println("Jugando...");
    }

    public String decirNombre(){
        return nombre;
    }

    public String decirEspecie(){
        return especie;
    }

    public String decirColor(){
        return color;
    }

    public abstract String hablar();
}
