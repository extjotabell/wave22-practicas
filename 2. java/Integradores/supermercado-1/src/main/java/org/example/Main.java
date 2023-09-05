package org.example;

import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

     static FacturaService facturaService = new FacturaService();
     static ClienteService clienteService = new ClienteService();
    public static void main(String[] args) {
        clienteService.save(new Cliente(123, "Paula", "Lopez"));
        clienteService.save(new Cliente(254, "Jorge", "Venega"));
        clienteService.save(new Cliente(90, "Ana", "Sanchez"));
        clienteService.save(new Cliente(14, "Pablo", "Lopez"));

        clienteService.printAll();

        clienteService.delete(2);
        System.out.println();
        System.out.println("Lista de clientes actualizada: ");
        System.out.println();

        clienteService.printAll();

        clienteService.findByScannerDni();

        // Parte 2 del ejercicio

        List<Item> items = new ArrayList<>();
        Item i1 = new Item("C9AK", 20, 10.0);
        Item i2 = new Item("C0AP", 10, 20.0);
        Item i3 = new Item("CQA8", 40, 30.0);

        items.add(i1);
        items.add(i2);
        items.add(i3);
        Cliente cliente = new Cliente(43, "Olivia", "Perez");
        facturaService.save(new Factura(cliente, items));
        boolean clienteExistente = clienteService.findById(cliente.getDni()) != null;
        if(!clienteExistente){
            clienteService.save(cliente);
        }

    }
}