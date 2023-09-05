package org.example.clases;

public class Item {
    private String codigo;
    private String nombre;
    private Integer cantidad;
    private Integer costo;

    public Item(String codigo, String nombre, Integer cantidad, Integer costo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.costo = costo;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getCosto() {
        return costo;
    }

    public void setCosto(Integer costo) {
        this.costo = costo;
    }
}
