package org.example;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Localizador {

    private Cliente cliente;
    private Double total;
    private List<Reserva> reservas;

    public Localizador(Cliente cliente, List<Reserva> reservas) {
        this.cliente = cliente;
        this.reservas = reservas;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Reserva> getReserva() {
        return reservas;
    }

    public void setReserva(List<Reserva> reserva) {
        this.reservas = reserva;
    }

    public Double calculoTotalLocalizador(Repositorio repositorio){
        Double totalDescuento = 0.0;
        List<TipoReserva> tiposReserva = new ArrayList<>();
        tiposReserva.add(TipoReserva.VIAJE);
        tiposReserva.add(TipoReserva.HOTEL);
        tiposReserva.add(TipoReserva.TRANSPORTE);
        tiposReserva.add(TipoReserva.COMIDA);
        int reservasHotel=0;
        int reservasViaje=0;

        //Descuento1
        if(repositorio.cantidadLocalizadoresPorCliente(this.cliente) > 1){
            totalDescuento+=0.05;
        }

        //Descuento2
        for (Reserva reserva : this.reservas) {
            if (reserva.getTipo().equals(TipoReserva.HOTEL)){
                tiposReserva.remove(TipoReserva.HOTEL);
                reservasHotel+=1;
            }else if(reserva.getTipo().equals(TipoReserva.COMIDA)){
                tiposReserva.remove(TipoReserva.COMIDA);
            }else if(reserva.getTipo().equals(TipoReserva.VIAJE)){
                tiposReserva.remove(TipoReserva.VIAJE);
                reservasViaje+=1;
            }else{
                tiposReserva.remove(TipoReserva.TRANSPORTE);
            }
        }
        if(tiposReserva.isEmpty()){
            totalDescuento+=0.1;
        }

        //Descuento3
        if(reservasHotel == 2 || reservasViaje == 2){//El enunciado especifica 2 de cada tipo
            for (Reserva reserva : this.reservas) {
                if (reserva.getTipo().equals(TipoReserva.HOTEL)){
                    reserva.setMonto(reserva.getMonto()*0.95);
                }else if(reserva.getTipo().equals(TipoReserva.VIAJE)){
                    reserva.setMonto(reserva.getMonto()*0.95);
                }
            }
        }
        Double total= reservas.stream().mapToDouble(Reserva::getMonto).sum();
        this.setTotal(total*(1-totalDescuento));
        return this.total;
    }


    @Override
    public String toString() {
        return "Localizador{" +
                "total=" + total +
                ", cliente=" + cliente +
                ", reserva=" + reservas +
                '}';
    }


}
