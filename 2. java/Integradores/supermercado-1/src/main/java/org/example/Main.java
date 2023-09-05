package org.example;

import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Set<Cliente> clientes = new HashSet<>();
        Cliente c1 = new Cliente(123, "Paula", "Lopez");
        Cliente c2 = new Cliente(254, "Jorge", "Venega");
        Cliente c3 = new Cliente(90, "Ana", "Sanchez");
        Cliente c4 = new Cliente(14, "Pablo", "Lopez");
        Cliente c5 = new Cliente(20, "Juan", "Sanchez");
        Cliente c6 = new Cliente(900, "Marcos", "Lopez");
        Cliente c7 = new Cliente(1020, "Agustin", "Sanchez");
        Cliente c8 = new Cliente(800, "Sofia", "Lopez");
        Cliente c9 = new Cliente(11, "Martha", "Sanchez");
        clientes.add(c1);
        clientes.add(c2);
        clientes.add(c3);
        clientes.add(c4);
        clientes.add(c5);
        clientes.add(c6);
        clientes.add(c7);
        clientes.add(c8);
        clientes.add(c9);


        for (Cliente cliente: clientes) {
            System.out.println(cliente.toString());
        }

        clientes.remove(2);
        System.out.println();
        System.out.println("Lista de clientes actualizada: ");
        System.out.println();

        for (Cliente cliente: clientes) {
            System.out.println(cliente.toString());
            System.out.println();
        }

        System.out.println("Ingrese un dni para buscar al cliente: ");

        Scanner scan= new Scanner(System.in);

        Integer dni= scan.nextInt();

        System.out.println("Buscando usuario con el dni..." + dni);

        boolean encontrado = clientes.stream().anyMatch(c -> c.getDni().equals(dni));

        if (encontrado) {
            System.out.println("DNI encontrado con los siguientes datos: ");
            clientes.stream().filter(c -> c.getDni().equals(dni)).forEach(System.out::println);
        } else {
            System.out.println("DNI no encontrado");
        }


    }
}