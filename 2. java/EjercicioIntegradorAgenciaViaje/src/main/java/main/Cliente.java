package main;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private String nombre;
    private String dni;
    private List<Localizador> localizadores = new ArrayList<>();

    public Cliente(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public void agregarLocalizador(Localizador l) {
        localizadores.add(l);
    }

    public double calcularPrecio(Localizador l) {
        double precio = l.calcularPrecio();
        if(tieneDescuento())
            precio = precio * 0.95;
        return precio;
    }

    public boolean tieneDescuento() {
        return localizadores.size() >= 2;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", dni='" + dni + '\'' +
                ", localizadores=" + localizadores.toString() +
                '}';
    }
}
