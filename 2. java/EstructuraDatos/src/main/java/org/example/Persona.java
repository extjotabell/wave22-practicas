package org.example;
import java.util.Map;
public class Persona {
    private int id;
    private String nombre;
    private String apellido;
    private String dni;
    private int edad;

    public Persona(int id, String nombre, String apellido, String dni, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.edad = edad;
    }

    public String toString(){
        return "id: " + id + " " +"nombre: " + nombre + " " + "apellido: " + apellido + " " + "dni: " + dni + " " + "edad: " + edad;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
