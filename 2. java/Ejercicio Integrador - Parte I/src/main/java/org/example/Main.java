package org.example;

import org.example.Models.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Cliente cli1 = new Cliente(45855852L, "Camila", "Lemos");
        Cliente cli2 = new Cliente(36942544L, "Cristina", "Romero");
        Cliente cli3 = new Cliente(45882144L, "Matias", "Comba");

        List<Cliente> listaClientes = new ArrayList<Cliente>();
        listaClientes.add(cli1);
        listaClientes.add(cli2);
        listaClientes.add(cli3);

        for (Cliente cli: listaClientes){
            System.out.println(cli.toString());
        }
        Scanner teclado = new Scanner(System.in);
        borrarCliente(teclado, listaClientes);
        buscarCliente(teclado, listaClientes);
    }

    private static void borrarCliente(Scanner teclado, List<Cliente> listaClientes){
        System.out.println("Ingrese el dni de la persona a borrar:");
        Long dniBorrar = teclado.nextLong();
        boolean find = false;

        for (Cliente c : listaClientes) {
            if (c.getDni().equals(dniBorrar)) {
                listaClientes.remove(c);
                find = true;
                break;
            }
        }
        if (find == false) {
            System.out.println("No se encontró el cliente a borrar");
        }
        else {
            System.out.println("Cliente borrado correctamente");
        }
    }

    private static void buscarCliente(Scanner teclado, List<Cliente> listaClientes){
        System.out.println("Ingrese el dni a buscar");
        Long dniBuscar = teclado.nextLong();

        boolean find = false;
        for (Cliente c : listaClientes) {
            if (c.getDni().equals(dniBuscar)) {
                System.out.println("----Cliente encontrado, sus datos son: ----");
                System.out.println(c.toString());
                find = true;
                break;
            }
        }

        if (find == false) {
            System.out.println("Cliente no encontrado");
        }
    }
}