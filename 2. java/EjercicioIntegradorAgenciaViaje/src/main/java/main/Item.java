package main;

public abstract class Item {

    private String descripcion;
    private double precio;

    public Item(String descripcion, double precio) {
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return "Item{" +
                "descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                '}';
    }
}