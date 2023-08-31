public class Distribuidora {
    public static void main(String[] args) {
        Producto[] productos = new Producto[4];
        productos[0] = new Perecedero(2, "Carne", 23.99);
        productos[1] = new NoPerecedero("Lenteja", "Lenteja", 23.23);
        productos[2] = new Perecedero(6, "Pescado", 32.99);
        productos[3] = new NoPerecedero("Arroz", "Arroz", 13.23);

        int cantidadAVender = 5;

        double precioTotal = 0;
        for (Producto producto : productos) {
            double precioProducto = producto.calcular(cantidadAVender);
            System.out.println("Precio total de " + cantidadAVender + " " + producto.getNombre() + ": $" + precioProducto);
            precioTotal += precioProducto;
        }
        System.out.println("Precio total de venta: $" + precioTotal);

    }
}
