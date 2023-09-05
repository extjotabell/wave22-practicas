package org.example;

import org.example.repository.CrudFactura;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        CrudFactura crudFactura = new CrudFactura();

        Cliente cliente1 = new Cliente("ABC123","Cliente1","Perez");
        Cliente cliente2 = new Cliente("DEF123","Cliente2","Sanchez");
        Cliente cliente3 = new Cliente("GHI123","Cliente3","Ramirez");

        List<Cliente> clienteList = new ArrayList<>();
        clienteList.add(cliente1);
        clienteList.add(cliente2);
        clienteList.add(cliente3);

        clienteList.forEach(System.out::println);
        clienteList.remove(cliente2);
        clienteList.forEach(System.out::println);

        Scanner teclado = new Scanner(System.in);

        System.out.println("Ingrese un DNI");
        String dniABuscar = teclado.nextLine();

        Cliente cliente = clienteList.stream().filter(cli -> cli.getDni().equals(dniABuscar)).findFirst().orElse(null);
        if (cliente != null){
            System.out.println("Busqueda al n° de DNI: " + dniABuscar);
            System.out.println("- " + cliente);
        }else {
            System.out.println("No hubo coincidencias");
        }

        Item item1 = new Item("001", "arroz", 2, 400.0);
        Item item2 = new Item("020", "fideo", 4, 300.0);
        Item item3 = new Item("098", "leche", 6, 350.0);

        List<Item> itemList = new ArrayList<>();
        itemList.add(item1);
        itemList.add(item2);
        itemList.add(item3);

        Factura factura1 = new Factura(1,cliente1,itemList);

        crudFactura.save(factura1);
        System.out.println(crudFactura.getAll());
    }


}