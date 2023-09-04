package org.example;

import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Cliente> clientes = new ArrayList<>();
        Cliente cliente1 = new Cliente("12345", "Juan Perez");
        Cliente cliente2 = new Cliente("123456", "Juan Perez 2");
        Cliente cliente3 = new Cliente("123451", "Juan Perez 3");

        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);

        System.out.println("Clientes iniciales: \n");
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }

/*        System.out.println("Clientes actualizados: \n");
        clientes.remove(cliente1);
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
        Scanner scanner = new Scanner(System.in);

        System.out.print("Por favor, ingrese el dni que desea buscar: ");
        String dni = scanner.nextLine();

        Optional<Cliente> clienteFound = clientes.stream().filter(cliente -> Objects.equals(cliente.getDni(), dni)).findFirst();
        if(clienteFound.isPresent()){
            System.out.println(clienteFound.get());
        }else{
            System.out.println("No se encontró el cliente en la base de datos.");
        }
        scanner.close();*/
        Optional<Cliente> clienteFound = clientes.stream().filter(cliente -> Objects.equals(cliente.getDni(), cliente2.getDni())).findFirst();
        if(clienteFound.isPresent()){
            Item item1 = new Item("123", "papa", 2, 10.0);
            Item item2 = new Item("123", "papa", 1, 10.0);
            Item item3 = new Item("123", "papa", 3, 10.0);
            Item item4 = new Item("123", "papa", 1, 10.0);
            List<Item> items = new ArrayList<>();
            items.add(item1);
            items.add(item2);
            items.add(item3);
            items.add(item4);
            Factura factura = new Factura(cliente2, items);
            System.out.println(factura);
        }else{
            System.out.println("No se encontró el cliente en la base de datos.");
        }


    }
}