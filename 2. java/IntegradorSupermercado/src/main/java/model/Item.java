package model;

public class Item {
    private int codigo;
    private String nombre;
    private int cantidadComprada;
    private double precio;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadComprada() {
        return cantidadComprada;
    }

    public void setCantidadComprada(int cantidadComprada) {
        this.cantidadComprada = cantidadComprada;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Item(int codigo, String nombre, int cantidadComprada, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidadComprada = cantidadComprada;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Item{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", cantidadComprada=" + cantidadComprada +
                ", precio=" + precio +
                '}';
    }
}
