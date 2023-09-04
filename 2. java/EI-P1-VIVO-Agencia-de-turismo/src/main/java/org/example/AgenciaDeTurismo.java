package org.example;

import org.example.Productos.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AgenciaDeTurismo {
    private Map<Cliente, List<Localizador>> localizadoresPorCliente;
    private MetricasVentas metricasVentas;
    // private  static  final DESCUENTO_POR_LOCALIZADORES = 0.5;


    public AgenciaDeTurismo() {
        this.localizadoresPorCliente = new HashMap<Cliente, List<Localizador>>();
        this.metricasVentas = new MetricasVentas();
    }

    public Localizador realizadarLocalizador(List<Producto> productos, Cliente cliente){
        this.agregarCliente(cliente);

        double precioTotal = this.getPrecioTotal(productos, cliente);
        Localizador localizador = new Localizador(productos, cliente, precioTotal);
        this.localizadoresPorCliente.get(cliente).add(localizador);

        return localizador;
    }

    private void agregarCliente(Cliente cliente) {
        if (!this.localizadoresPorCliente.containsKey(cliente))
            this.localizadoresPorCliente.put(cliente, new ArrayList<Localizador>());
    }

    private double getPrecioTotal(List<Producto> productos, Cliente cliente) {
        double totalSinDescuento = productos.stream().mapToDouble(Producto::getPrecio).sum();
        double porcentajeDeDescuento = getDescuentos(productos, cliente);

        return totalSinDescuento*(1-porcentajeDeDescuento);
    }

    private double getDescuentos(List<Producto> productos, Cliente cliente){
        double descuentoPorLocalizadores = this.aplicaDescuentoPorLocalizadores(cliente) ? 0.05 : 0;
        double descuentoPorPaqueteCompleto = this.aplicaDescuentoPorPaqueteCompleto(productos) ? 0.10 : 0;
        double descuentoMultiplesReservasDeHotelOVuelo = this.aplicaDescuentoMultiplesReservasDeHotelOVuelo(productos) ? 0.05 : 0;

        return  descuentoPorLocalizadores + descuentoPorPaqueteCompleto + descuentoMultiplesReservasDeHotelOVuelo;
    }

    private boolean aplicaDescuentoMultiplesReservasDeHotelOVuelo(List<Producto> productos) {
        return tieneDosReservas(productos, Hotel.class) ||
                tieneDosReservas(productos, Vuelo.class);
    }

    private static boolean tieneDosReservas(List<Producto> productos, Class<? extends Producto> claseDelProducto) {
        return productos.stream().filter(producto -> producto.getClass().equals(claseDelProducto)).count() >= 2;
    }

    private boolean aplicaDescuentoPorLocalizadores(Cliente cliente) {
        return this.localizadoresPorCliente.get(cliente).size() >= 2;
    }

    private boolean aplicaDescuentoPorPaqueteCompleto(List<Producto> productos){
        return productos.stream().anyMatch(producto -> producto instanceof Hotel) &&
                productos.stream().anyMatch(producto -> producto instanceof Comida) &&
                productos.stream().anyMatch(producto -> producto instanceof Vuelo) &&
                productos.stream().anyMatch(producto -> producto instanceof Transporte);

    }

    public int cantidadLocalizadoresVendidos(){
        return this.metricasVentas.cantidadLocalizadoresVendidos(this.localizadoresPorCliente);
    }

    public int cantidadReservas(){
        return this.metricasVentas.cantidadReservas(this.localizadoresPorCliente);
    }

    public Map<Class<? extends Producto>, List<Producto>> reservasPorTipo(){
        return this.metricasVentas.reservasPorTipo(this.localizadoresPorCliente);
    }

    public double totalVentas(){
        return this.metricasVentas.totalVentas(this.localizadoresPorCliente);
    }

    public double promedioDeVentas(){
        return this.metricasVentas.promedioDeVentas(this.localizadoresPorCliente);
    }
}
