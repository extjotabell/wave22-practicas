package org.example;

import org.example.models.*;

import java.util.stream.Collectors;

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

        ConsultaLocalizadores query = new ConsultaLocalizadores(repoLocalizadores);
        System.out.println("Cantidad de localizadores y reservas: " + query.getCantidad());
        System.out.println("--Cantidad de reservas por tipo--");
        query.ObtenerCantidadDeReservasClasificadas().forEach((key, value) -> System.out.println(key + ": " + value));
        System.out.println("Total de ventas: $" + query.totalDeVentas());
        System.out.println("Promedio de ventas: $" + query.promedioDeVentas());
    }
}