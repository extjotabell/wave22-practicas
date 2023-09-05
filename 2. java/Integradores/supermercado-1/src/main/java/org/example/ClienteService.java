package org.example;

import java.util.*;

public class ClienteService implements CRUD<Cliente, Integer>{

    Set<Cliente> clientes = new HashSet<>();
    @Override
    public void save(Cliente entity) {
        clientes.add(entity);
    }

    @Override
    public void delete(Integer integer) {
        clientes.remove(integer);
    }

    @Override
    public Cliente update(Cliente entity) {
        return entity;
    }

    @Override
    public Cliente findById(Integer integer) {
        return clientes.stream()
                .filter(cliente -> cliente.getDni().equals(integer))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void printAll() {
        for (Cliente cliente: clientes) {
            System.out.println(cliente.toString());
        }
    }

    public void findByScannerDni(){
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
