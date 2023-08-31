package org.example;

public class Main {
    public static void main(String[] args) {

        Distribuidora distribuidora = new Distribuidora();
        
        NoPerecedero producto1 = new NoPerecedero("Arroz", 15.23, "Granos");
        Perecedero producto2 = new Perecedero("Carne", 100, 4);
        Perecedero producto3 = new Perecedero("Pescado", 200, 1);
        Perecedero producto4 = new Perecedero("Pollo", 30.52, 2);
        NoPerecedero producto5 = new NoPerecedero("Frijoles", 4.23, "Legumbre");

        distribuidora.ingresarProducto(producto1);
        distribuidora.ingresarProducto(producto2);
        distribuidora.ingresarProducto(producto3);
        distribuidora.ingresarProducto(producto4);
        distribuidora.ingresarProducto(producto5);

        distribuidora.venderProductos(5);

    }
}