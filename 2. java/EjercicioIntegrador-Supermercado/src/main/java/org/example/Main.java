package org.example;

import Repositories.ClienteRepository;
import models.Cliente;
import models.Factura;
import models.Producto;
import models.Supermercado;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Supermercado supermercado = new Supermercado("El economico", new ArrayList<>(
                List.of(
                        new Cliente(324234, "Luciana", "Monardez"),
                        new Cliente(324243, "Pepito", "Jose"),
                        new Cliente(324234234, "Mirtha", "Legrand")
                )), new ArrayList<Factura>());

        //agrego una factura de un cliente que ya existe
        Factura facturaClienteExistente = new Factura(supermercado.getClientes().get(2), List.of(
                new Producto(87988, "Pure de tomate", 2, (double) 250),
                new Producto(4, "Azucar", 1, (double) 850),
                new Producto(6, "Fideos", 3, (double) 450.50)
        ));

        //agrego factura de un nuevo cliente
        Factura facturaNuevoCliente = new Factura(new Cliente(
                23123112, "Juan", "Carlos"
        ), List.of(
                new Producto(1, "Pan", 1, (double) 100),
                new Producto(10, "Dulce de leche", 3, (double) 753.50),
                new Producto(34354, "Lavandina", 1, (double) 900)
        ));

        supermercado.mostrarClientes(supermercado.getClientes());
        supermercado.eliminarCliente(supermercado.getClientes().get(0));
        supermercado.mostrarClientes(supermercado.getClientes());

        supermercado.clientePorDni(324234234);

        supermercado.agregarFactura(facturaClienteExistente);
        supermercado.agregarFactura(facturaNuevoCliente);
    }
}