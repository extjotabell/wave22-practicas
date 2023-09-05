package org.example.clases;

public class Cliente {
    private String dni;
    private String nombre;
    private String apellido;

    public Cliente(String dni, String nombre, String apellido) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public void presentarInformacion(){
        System.out.println("Nombre: "+getNombre()+"\n" +
                "Apellido: "+getApellido()+"\n" +
                "DNI: "+getDni());
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }
}
