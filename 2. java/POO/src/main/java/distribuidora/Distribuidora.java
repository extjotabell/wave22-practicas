package distribuidora;

import java.util.Arrays;
import java.util.List;

public class Distribuidora {
    public static void main(String[] args) {
        Producto[] listaProductos = new Producto[5];
        listaProductos[0] = new Perecedero("Leche", 380, 1);
        listaProductos[1] = new Perecedero("Huevos", 700, 2);
        listaProductos[2] = new Perecedero("Bananas", 400, 3);
        listaProductos[3] = new NoPerecedero("Café", 800, "Infusiones");
        listaProductos[4] = new Perecedero("Azúcar", 600, 6);

        double resultado = 0;

        for(Producto p : listaProductos){
            resultado += p.calcular(5);
        }

        System.out.println(resultado);
        List<Producto> arrayLProductos = Arrays.asList(listaProductos);

    }
}
