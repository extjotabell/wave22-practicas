package org.example;

public class Distribuidora {
    public static void main(String[] args) {
        Producto[] productos = new Producto[3];

        Producto arvejas =  new Producto("Arvejas",50);
        Producto arroz =  new Perecedero("Arroz",100, 1);
        Producto jabon =  new NoPerecedero("Jabon",20,"Limpieza");

        productos[0] = arvejas;
        productos[1] = arroz;
        productos[2] = jabon;

        for(int i = 0; i < productos.length; i++){
            System.out.println("Precio del producto " + productos[i].getNombre() + " $" + productos[i].calcular(5));
        }
    }
}
