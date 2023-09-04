package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Supermercado supermercado = new Supermercado();

        Cliente c1 = new Cliente("123", "Pepe");
        Cliente c2 = new Cliente("456", "Juan");
        Cliente c3 = new Cliente("789", "Fran");

        // Parte 1 - 1
        supermercado.agregarCliente(c1);
        supermercado.agregarCliente(c2);
        supermercado.agregarCliente(c3);

        // Parte 1 - 2
        supermercado.mostrarClientes();

        // Parte 1 - 3
        supermercado.borrarCliente("123");
        supermercado.mostrarClientes();

        // Parte 1 - 4
        supermercado.buscarCliente("456");
        supermercado.buscarCliente("123");

        // Parte 2
        List<Item> itemList = new ArrayList<>();
        itemList.add(new Item("Papa", 10.0, 2, "123"));
        itemList.add(new Item("Leche", 15.0, 3, "234"));
        itemList.add(new Item("Pan", 15.0, 1, "155"));

        System.out.println(supermercado.crearFactura(c2, itemList, "111"));
    }
}