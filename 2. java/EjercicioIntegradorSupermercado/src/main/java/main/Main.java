package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        List<Cliente> clientes = new ArrayList<>();
        Cliente c1 = new Cliente("Rodrigo", "Baliani", "1234");
        Cliente c2 = new Cliente("Matias", "Gomez", "1235");
        Cliente c3 = new Cliente("Barbara", "Yunnino", "1236");
        clientes.add(c1);
        clientes.add(c2);
        clientes.add(c3);

        clientes.forEach(System.out::println);

        clientes.remove(1);
        clientes.forEach(System.out::println);

        Scanner s = new Scanner(System.in);
        System.out.println("Ingrese el DNI del cliente que desea buscar:");
        String dni = s.nextLine();
        Cliente cliente = clientes.stream().filter(c -> c.getDni().equals(dni)).findFirst().orElse(null);
        if(cliente != null)
            System.out.println(cliente);
        else
            System.out.println("Cliente no encontrado");
    }
}
