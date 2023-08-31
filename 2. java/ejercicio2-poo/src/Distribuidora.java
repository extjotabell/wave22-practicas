import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Distribuidora {
    List<Producto> productos = new ArrayList<>();

    public void addProducto(Producto producto) {
        productos.add(producto);
    }

    public double imprimirPrecioTotal() {
        double precioTotal = 0;
        for (Producto producto : productos) {
            precioTotal += producto.getPrecio();
        }
        return precioTotal;
    }

    public String imprimirPrecioPorTipo() {
        double totalPrecioPerecedero = 0;
        double totalPrecioNoPerecedero = 0;

        for (Producto producto : productos) {
            if (producto instanceof Perecedero) {
                totalPrecioPerecedero += producto.getPrecio();
            } else if (producto instanceof NoPerecedero) {
                totalPrecioNoPerecedero += producto.getPrecio();
            }
        }
        return "El total para productos perecederos es de: $" + totalPrecioPerecedero
                + ". Y el total para productos no perecederos es de: $ " + totalPrecioNoPerecedero;
    }
}
