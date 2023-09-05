package org.example;

import org.example.clases.Cliente;
import org.example.clases.Gestor;
import org.example.clases.Item;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Gestor gestor = new Gestor();

        Cliente clienteA = new Cliente("432023322", "Ricardo", "Darin");
        Cliente clienteB = new Cliente("404021132", "Armando Esteban", "Quito");
        Cliente clienteC = new Cliente("133073756", "Natalia", "Natalia");

        gestor.alta(clienteA);
        gestor.alta(clienteB);
        gestor.alta(clienteC);

        Item itemA = new Item("B21", "Cuaderno",10, 100);
        Item itemB = new Item("B23", "Lapiz",5, 25);

        ArrayList<Item> listaItems = new ArrayList<>();
        listaItems.add(itemA);
        listaItems.add(itemB);

        gestor.lectura(clienteA.getDni());
        gestor.generarCompra(clienteA, listaItems);
        listaItems.remove(itemA);
        gestor.generarCompra(clienteA, listaItems);

        gestor.verFacturas(clienteA);



    }



}
