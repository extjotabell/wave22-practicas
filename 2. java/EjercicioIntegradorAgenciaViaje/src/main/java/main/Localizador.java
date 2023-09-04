package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Localizador {

    private List<Item> items = new ArrayList<Item>();

    public void agregarItem(Item item) {
        items.add(item);
    }

    public double calcularPrecio() {
        double precio = items.stream().mapToDouble(Item::getPrecio).sum()-calcularDescuentoHotelViaje();
        if(tieneDescuentoPaquete())
            precio = precio * 0.9;
        return precio;
    }

    private boolean tieneDescuentoPaquete() {
        boolean dto = false;
        long cantidadBoletoViaje = items.stream().filter(i -> i instanceof BoletoViaje).count();
        long cantidadHotel = items.stream().filter(i -> i instanceof Hotel).count();
        long cantidadTransporte = items.stream().filter(i -> i instanceof Transporte).count();
        long cantidadComida = items.stream().filter(i -> i instanceof Comida).count();
        if(cantidadComida >= 1 && cantidadTransporte >= 1 && cantidadHotel >= 1 && cantidadBoletoViaje >= 1)
            dto = true;
        return dto;
    }

    private double calcularDescuentoHotelViaje() {
        List<Item> hoteles = items.stream().filter(i -> i instanceof BoletoViaje).collect(Collectors.toList());
        List<Item> boletosDeViaje = items.stream().filter(i -> i instanceof Hotel).collect(Collectors.toList());
        double dto = 0;
        if(hoteles.size() >= 2) {
            double totalHoteles = hoteles.stream().mapToDouble(Item::getPrecio).sum()*0.05;
            dto += totalHoteles;
        }
        if(boletosDeViaje.size() >= 2) {
            double totalBoleto = boletosDeViaje.stream().mapToDouble(Item::getPrecio).sum()*0.05;
            dto += totalBoleto;
        }
        return dto;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Localizador{" +
                "items=" + items +
                '}';
    }
}
