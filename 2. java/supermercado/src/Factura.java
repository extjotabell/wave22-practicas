import java.util.ArrayList;
import java.util.List;

public class Factura {
    private Cliente cliente;
    private List<Producto> productos = new ArrayList<>();
    private double precioTotal;

    public Factura(Cliente cliente) {
        this.cliente = cliente;
        this.precioTotal = 0;
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }


    public double getPrecioTotal() {
        double total = 0.0;
        for (Producto producto: productos ) {
            total += producto.getPrecio();
        }
        return total;
    }
}
