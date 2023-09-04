package org.example;

import org.example.models.Cliente;
import org.example.models.Localizador;
import org.example.models.RepositorioClientes;
import org.example.models.RepositorioLocalizadores;

public class Main {
    public static void main(String[] args) {

        RepositorioClientes repoClientes = new RepositorioClientes();
        RepositorioLocalizadores repoLocalizadores = new RepositorioLocalizadores();

        Cliente cliente1 = new Cliente("Martin Lopez", "A345672");
        repoClientes.agregarCliente(cliente1);
        Cliente cliente2 = new Cliente("Juana Suben", "A333372");
        repoClientes.agregarCliente(cliente2);

        cliente1.hacerCompra(1, 2, 2, 2, repoLocalizadores);
        cliente1.hacerCompra(1, 2, 2, 2, repoLocalizadores);
        cliente1.hacerCompra(1, 2, 2, 2, repoLocalizadores);

        cliente2.hacerCompra(1, 0, 0, 2, repoLocalizadores);

        repoLocalizadores.getListaDeLocalizadores().forEach(System.out::println);

    }
}