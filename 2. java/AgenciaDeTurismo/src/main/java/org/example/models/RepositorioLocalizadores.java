package org.example.models;

import java.util.ArrayList;
import java.util.List;

public class RepositorioLocalizadores {
    private List<Localizador> listaDeLocalizadores;

    public RepositorioLocalizadores() {
        listaDeLocalizadores = new ArrayList<>();
    }

    public RepositorioLocalizadores(List<Localizador> listaDeLocalizadores) {
        this.listaDeLocalizadores = listaDeLocalizadores;
    }

    public List<Localizador> getListaDeLocalizadores() {
        return listaDeLocalizadores;
    }

    public void setListaDeLocalizadores(List<Localizador> listaDeLocalizadores) {
        this.listaDeLocalizadores = listaDeLocalizadores;
    }

    public double calcularDescuentos(Reserva nuevaReserva, String dniCliente){
        double porcentajeDescuentos = 0.0;
        long numeroDeLocalizadores = listaDeLocalizadores.stream().filter(localizador -> localizador.getDniCliente().equals(dniCliente)).count();
        if (numeroDeLocalizadores >= 2){
            porcentajeDescuentos += 5;
        }
        if (nuevaReserva.esCompleta()){
            porcentajeDescuentos += 10;
        }
        if (nuevaReserva.aplicarTercerDescuento()){
            porcentajeDescuentos += 5;
        }
        return porcentajeDescuentos / 100;
    }

    public Localizador agregarReserva(Reserva nuevaReserva, String dniCliente){
        double precioSinDescuento = nuevaReserva.totalReserva();
        double descuento = calcularDescuentos(nuevaReserva, dniCliente);
        double precioConDescuento = precioSinDescuento * (1 - descuento);
        Localizador nuevoLocalizador = new Localizador(dniCliente, precioConDescuento, nuevaReserva);
        listaDeLocalizadores.add(nuevoLocalizador);
        return nuevoLocalizador;
    }

}
