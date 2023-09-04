package org.example;

public class Cliente {
    private String dni;
    private String nombreApellido;

    public Cliente(String dni, String nombreApellido) {
        this.dni = dni;
        this.nombreApellido = nombreApellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombreApellido() {
        return nombreApellido;
    }

    public void setNombreApellido(String nombreApellido) {
        this.nombreApellido = nombreApellido;
    }

    @Override
    public String toString() {
        return "Cliente: \n" +
                "dni= " + dni +
                ", nombreApellido= " + nombreApellido + "\n";
    }
}
