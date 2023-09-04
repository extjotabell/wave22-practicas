public class Producto {
    private String codigo;
    private String nombre;
    private int cantidadTotal;
    private double precio;

    public Producto(String codigo, String nombre, int cantidadTotal, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidadTotal = cantidadTotal;
        this.precio = precio;
    }

    public double getPrecio() {
        return precio;
    }
}
