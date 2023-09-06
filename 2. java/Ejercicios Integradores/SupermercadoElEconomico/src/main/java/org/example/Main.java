package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente("32453199", "Justin", "Bieber"));
        clientes.add(new Cliente("30747910", "Lionel", "Messi"));
        clientes.add(new Cliente("33213121", "Taylor", "Swift"));

        for(Cliente cliente : clientes){
            System.out.println(cliente.getDni() + " " + cliente.getNombre() + " " + cliente.getApellido());
        }

        clientes.remove(0);
        System.out.println("\nLista clientes post remove:");
        for(Cliente cliente : clientes){
            System.out.println(cliente.getDni() + " " + cliente.getNombre() + " " + cliente.getApellido());
        }

        Scanner input = new Scanner(System.in);
        System.out.println("\nIngrese un DNI para buscarlo en la lista de clientes:");
        String dniABuscar = input.next();
        Optional<Cliente> clienteEncontrado =  clientes.stream()
                .filter(cliente -> cliente.getDni().equals(dniABuscar))
                .findFirst();

        if(clienteEncontrado.isPresent()) {
            Cliente cliente = clienteEncontrado.get();
            System.out.println("Se ha encontrado el cliente:");
            System.out.println(cliente.getDni() + " " + cliente.getNombre() + " " + cliente.getApellido());
        }
        else{
            System.out.println("No se encontró un cliente con el DNI " + dniABuscar);
        }
    }
}