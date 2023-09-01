import java.util.ArrayList;

public class Distribuidora {
    public static void main(String[] args) {
        Producto[] productos = new Producto[]{
                new Perecedero("Manzanas", 10, 1),
                //new NoPerecedero("Cereal", 3.0, "Desayuno"),
                //new Perecedero("Leche", 2.0, 2),
                //new NoPerecedero("Galletas", 1.0, "Snack"),
                //new Perecedero("Pan", 10, 3),
                //new NoPerecedero("Arroz", 2.5, "Comida")
        };

        double precioTotal = 0;

        for (Producto producto : productos) {
            precioTotal += producto.calcular(5);
        }

        System.out.println("Precio total al vender 5 productos de cada tipo: " + precioTotal);
    }
}
