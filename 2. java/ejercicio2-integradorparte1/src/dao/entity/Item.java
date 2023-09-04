package dao.entity;

public class Item {
    private int id;
    private String descripcion;
    private int cantidad;
    private double precio;
    private double subTotal;

    public Item(int id, String descripcion, int cantidad, double precio) {
        this.id = id;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precio = precio;
        setSubTotal();
    }

    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setSubTotal() {
        this.subTotal = precio * cantidad;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", cantidad=" + cantidad +
                ", precio=" + precio +
                ", subTotal=" + subTotal +
                '}';
    }
}
