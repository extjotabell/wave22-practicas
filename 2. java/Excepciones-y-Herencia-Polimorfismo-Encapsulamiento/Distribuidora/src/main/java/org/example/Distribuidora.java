package org.example;

import java.util.ArrayList;
import java.util.List;

public class Distribuidora {
    public static void main(String[] args) {
        List<Producto> listaProductos = new ArrayList<Producto>();
        listaProductos.add(new Perecedero("Leche", 100, 3));
        listaProductos.add(new Perecedero("Yogurt", 200, 2));
        listaProductos.add(new Perecedero("Queso", 200, 1));
        listaProductos.add(new NoPerecedero("Miel", 20, "Miel y mermeladas"));
        listaProductos.add(new NoPerecedero("Chocolate Negro", 20, "Chocolate"));
        listaProductos.add(new NoPerecedero("Sal", 20, "Sal, azúcar y especias"));

        for(int i = 0; i < listaProductos.size(); i++){
            System.out.println("Nombre: " + listaProductos.get(i).getNombre());
            System.out.println("Precio: " + listaProductos.get(i).getPrecio());
            System.out.println("Precio por comprar 5 productos: " + listaProductos.get(i).calcular(5));
        }
    }
}

/*

Crear la clase NoPerecedero, la misma va a tener un atributo llamado tipo,
el mismo va a ser un String, crear setters, getters, constructor y método toString();
en esta clase el método calcular() va a hacer exactamente lo mismo que en la clase
Producto.

Crear una clase ejecutable llamada Distribuidora donde van a
crear un array de productos, imprimir el precio total al vender 5 productos
de cada tipo. Crear los elementos del array con los datos que quieras.

* */