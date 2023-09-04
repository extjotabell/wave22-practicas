package org.example;

import org.example.Productos.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        AgenciaDeTurismo agenciaDeTurismo = new AgenciaDeTurismo();
        // Parte 1
        // Caso 1
        Cliente cliente = new Cliente(1, "Pepe");
        List<Producto> productosC1 = new ArrayList<>();
        productosC1.add(new Hotel(100));
        productosC1.add(new Comida(100));
        productosC1.add(new Vuelo(100));
        productosC1.add(new Transporte(100));

        Localizador localizadorC1 = agenciaDeTurismo.realizadarLocalizador(productosC1, cliente);
        System.out.println(localizadorC1);

        // Caso 2
        List<Producto> productosC2 = new ArrayList<>();
        productosC2.add(new Hotel(100));
        productosC2.add(new Hotel(100));
        productosC2.add(new Vuelo(100));
        productosC2.add(new Vuelo(100));

        Localizador localizadorC2 = agenciaDeTurismo.realizadarLocalizador(productosC2, cliente);
        System.out.println(localizadorC2);

        // Caso 3
        Cliente clienteC3 = new Cliente(2, "Juan");
        List<Producto> productosC3 = new ArrayList<>();
        productosC3.add(new Hotel(100));
        productosC3.add(new Transporte(100));

        Localizador localizadorC3 = agenciaDeTurismo.realizadarLocalizador(productosC3, clienteC3);
        System.out.println(localizadorC3);

        // Caso 4
        List<Producto> productosC4 = new ArrayList<>();
        productosC4.add(new Hotel(100));
        productosC4.add(new Transporte(100));

        Localizador localizadorC4 = agenciaDeTurismo.realizadarLocalizador(productosC4, cliente);
        System.out.println(localizadorC4);

        // Caso 5
        List<Producto> productosC5 = new ArrayList<>();
        productosC5.add(new Hotel(100));
        productosC5.add(new Hotel(100));
        productosC5.add(new Comida(100));
        productosC5.add(new Vuelo(100));
        productosC5.add(new Transporte(100));

        Localizador localizadorC5 = agenciaDeTurismo.realizadarLocalizador(productosC5, cliente);
        System.out.println(localizadorC5);

        // Parte 2
        // Caso 1
        System.out.println("Cantidad de localizdores vendidos: " + agenciaDeTurismo.cantidadLocalizadoresVendidos());

        // Caso 2
        System.out.println("Cantidad de reservas totales: " + agenciaDeTurismo.cantidadReservas());

        // Caso 3
        System.out.println("Reservas por tipo: " + agenciaDeTurismo.reservasPorTipo());

        // Caso 4
        System.out.println("Ventas totales: " + agenciaDeTurismo.totalVentas());

        // Caso 5
        System.out.println("Promedio de ventas: " + agenciaDeTurismo.promedioDeVentas());
    }
}