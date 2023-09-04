package org.example;

import org.example.Productos.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MetricasVentas {
    public int cantidadLocalizadoresVendidos(Map<Cliente, List<Localizador>> localizadoresPorCliente) {
        int totalVendidos = 0;
        for (List<Localizador> localizadores: localizadoresPorCliente.values())
            totalVendidos += localizadores.size();

        return totalVendidos;
    }

    public int cantidadReservas(Map<Cliente, List<Localizador>> localizadoresPorCliente){
        int totalReservas = 0;
        for (List<Localizador> localizadores: localizadoresPorCliente.values())
            for (Localizador localizador: localizadores)
                totalReservas += localizador.getReservasDeProductos().size();

        return totalReservas;
    }

    public Map<Class<? extends Producto>, List<Producto>> reservasPorTipo(Map<Cliente, List<Localizador>> localizadoresPorCliente){
        Map<Class<? extends Producto>, List<Producto>> reservasPorTipo = new HashMap<>();

        reservasPorTipo.put(Hotel.class, new ArrayList<>());
        reservasPorTipo.put(Comida.class, new ArrayList<>());
        reservasPorTipo.put(Vuelo.class, new ArrayList<>());
        reservasPorTipo.put(Transporte.class, new ArrayList<>());

        for (List<Localizador> localizadores: localizadoresPorCliente.values()) {
            for (Localizador localizador : localizadores) {
                filtrarPorTipoDeProducto(Hotel.class, localizador, reservasPorTipo);
                filtrarPorTipoDeProducto(Comida.class, localizador, reservasPorTipo);
                filtrarPorTipoDeProducto(Vuelo.class, localizador, reservasPorTipo);
                filtrarPorTipoDeProducto(Transporte.class, localizador, reservasPorTipo);
            }
        }

        return reservasPorTipo;
    }

    private static void filtrarPorTipoDeProducto(Class<? extends Producto> tipo, Localizador localizador, Map<Class<? extends Producto>, List<Producto>> reservasPorTipo) {
        reservasPorTipo.get(tipo).addAll(
                localizador.getReservasDeProductos()
                        .stream()
                        .filter(producto -> producto.getClass().equals(tipo)).collect(Collectors.toList()));
    }

    public double totalVentas(Map<Cliente, List<Localizador>> localizadoresPorCliente)
    {
        double totalVentas = 0;
        for (List<Localizador> localizadores: localizadoresPorCliente.values())
            for (Localizador localizador: localizadores)
                totalVentas += localizador.getPrecioTotal();

        return totalVentas;
    }

    public double promedioDeVentas(Map<Cliente, List<Localizador>> localizadoresPorCliente)
    {
        return this.totalVentas(localizadoresPorCliente)/this.cantidadLocalizadoresVendidos(localizadoresPorCliente);
    }
}
