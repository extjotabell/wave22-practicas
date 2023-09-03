import java.util.List;

public class Factura {
    Cliente cliente;
    List<Producto> productos;
    double precioTotal;

    public Factura(Cliente cliente, List<Producto> productos, double precioTotal) {
        this.cliente = cliente;
        this.productos = productos;
        this.precioTotal = precioTotal;
    }
}
