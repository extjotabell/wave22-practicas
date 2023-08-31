public class Distribuidora {
    public static void main(String[] args) {
        Producto [] productos = new Producto[10];

        productos[0] = new Perecedero("Leche",  500, 2);
        productos[1] = new Perecedero("Carne", 1000, 3);
        productos[2] = new Perecedero("Acelga", 300, 5);
        productos[3] = new Perecedero("Queso", 750, 1);
        productos[4] = new Perecedero("Manzana", 20, 4);

        productos[5] = new NoPerecedero("Arroz", 400, "cereal");
        productos[6] = new NoPerecedero("Cafe", 1000, "grano");
        productos[7] = new NoPerecedero("Fideos", 300, "pasta");
        productos[8] = new NoPerecedero("Yerba", 1500, "bebida");
        productos[9] = new NoPerecedero("Garbanzos", 150, "legumbres");

        double total = 0;
        for (Producto producto : productos){
            total = total + producto.calcular(1);
        }

        System.out.println("El total vendido es :" + total);
    }
}
