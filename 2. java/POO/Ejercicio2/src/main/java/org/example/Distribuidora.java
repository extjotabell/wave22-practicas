package org.example;

import java.util.ArrayList;
import java.util.List;
import java.text.DecimalFormat;

public class Distribuidora {
    public static void main(String[] args) {
        List<Producto> productos = new ArrayList<>();
        double precioFinal = 0;

        productos.add(new Perecedero("Leche", 2.5, 1));
        productos.add(new Perecedero("Pan", 1.0, 2));
        productos.add(new Perecedero("Yogur", 1.8, 3));
        productos.add(new Perecedero("Huevos", 3.0, 2));
        productos.add(new Perecedero("Pollo", 5.0, 1));
        productos.add(new NoPerecedero("Arroz", 2.0, "Granos"));
        productos.add(new NoPerecedero("Aceite", 3.0, "Líquido"));
        productos.add(new NoPerecedero("Sal", 1.0, "Condimento"));
        productos.add(new NoPerecedero("Azúcar", 2.0, "Endulzante"));
        productos.add(new NoPerecedero("Pasta", 1.5, "Granos"));

        for(Producto producto : productos){
            precioFinal += producto.calcular(2);
        }
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println("Total a pagar: $" + Double.parseDouble(df.format(precioFinal)));
    }
}
