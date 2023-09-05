package org.example;

import org.example.clases.Cliente;

import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Cliente clienteA = new Cliente("432023322", "Ricardo", "Darin");
        Cliente clienteB = new Cliente("404021132", "Armando Esteban", "Quito");
        Cliente clienteC = new Cliente("133073756", "Natalia", "Natalia");

        //Punto 1
        Map<String,Cliente> clientes = new HashMap<>();
        clientes.put(clienteA.getDni(), clienteA);
        clientes.put(clienteB.getDni(), clienteB);
        clientes.put(clienteC.getDni(), clienteC);


        for (String dni: clientes.keySet()) {
            clientes.get(dni).presentarInformacion();
            System.out.println("\n");
        }

        //Punto 2
        System.out.println("---------------------------------------------\n");

        clientes.remove(clienteC.getDni());
        for (String dni: clientes.keySet()) {
            clientes.get(dni).presentarInformacion();
            System.out.println("\n");
        }

        //Punto 3
        System.out.println("---------------------------------------------\n");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese su número de DNI: ");
        String dni = scanner.nextLine();
        scanner.close();
        buscarCliente(clientes, dni);

    }

    public static void buscarCliente(Map<String,Cliente> lista, String dni){
        if(lista.containsKey(dni)){
            lista.get(dni).presentarInformacion();
        }else {
            System.out.println("cliente no encontrado!");
        }
    }

    }
