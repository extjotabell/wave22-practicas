package org.agencia_turismo;

public class Cliente {

    public Cliente(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    private Integer id;
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setDni(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

}
