package org.example.models;

import java.util.HashMap;
import java.util.Map;

public class ConsultaLocalizadores {
    private RepositorioLocalizadores repositorioLocalizadores;

    public ConsultaLocalizadores(RepositorioLocalizadores repositorioLocalizadores) {
        this.repositorioLocalizadores = repositorioLocalizadores;
    }

    public int getCantidad() {
        return repositorioLocalizadores.getListaDeLocalizadores().size();
    }

    public Map<String, Integer> ObtenerCantidadDeReservasClasificadas() {
        Map<String, Integer> tiposDeReserva = new HashMap<>();
        repositorioLocalizadores.getListaDeLocalizadores().forEach(
                localizador -> {
                    int valueToUpdate = tiposDeReserva.getOrDefault("hotel", 0) + localizador.getReserva().getReservasDeHotel();
                    tiposDeReserva.put("hotel", valueToUpdate);
                    valueToUpdate = tiposDeReserva.getOrDefault("comida", 0) + localizador.getReserva().getComidas();
                    tiposDeReserva.put("comida", valueToUpdate);
                    valueToUpdate = tiposDeReserva.getOrDefault("boletoDeViaje", 0) + localizador.getReserva().getBoletosViaje();
                    tiposDeReserva.put("boletoDeViaje", valueToUpdate);
                    valueToUpdate = tiposDeReserva.getOrDefault("transporte", 0) + localizador.getReserva().getTransportes();
                    tiposDeReserva.put("transporte", valueToUpdate);
                }
        );
        return tiposDeReserva;
    }

    public double totalDeVentas() {
        return repositorioLocalizadores.getListaDeLocalizadores().stream().mapToDouble(Localizador::getTotalConDescuento).sum();
    }
    public double promedioDeVentas() {
        return repositorioLocalizadores.getListaDeLocalizadores().stream().mapToDouble(Localizador::getTotalConDescuento).average().orElse(0);
    }


}
