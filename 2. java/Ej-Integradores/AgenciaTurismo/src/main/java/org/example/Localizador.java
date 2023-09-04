package org.example;
import java.util.List;
import java.util.stream.Collectors;

public class Localizador {
    private Cliente cliente;
    private List<Reserva> reserva;
    private double total;

    public Localizador(Cliente cliente, List<Reserva> reserva) {
        this.cliente = cliente;
        this.reserva = reserva;
        descuentoReserva();
        calcularTotal();
        cliente.agregarLocalizador(this);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Reserva> getReserva() {
        return reserva;
    }

    public double getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return "Localizador" +
                "cliente=" + cliente +
                ", reserva=" + reserva +
                ", total=" + total;
    }

    private void descuentoReserva(){
        List<Reserva> reservasHotel =  reserva.stream().filter(x->x instanceof ReservaServicio).filter(x->((ReservaServicio) x).getTipoReserva().equals("Hotel")).collect(Collectors.toList());
        List<Reserva> reservasBoletos =  reserva.stream().filter(x->x instanceof ReservaServicio).filter(x->((ReservaServicio) x).getTipoReserva().equals("Boleto")).collect(Collectors.toList());


        if(reservasHotel.size() >= 2){
            for (Reserva reservaTipo1: reservasHotel
                 ) {
                reservaTipo1.aplicarDescuento(0.95);
            }
        }

        if(reservasBoletos.size() >= 2){
            for (Reserva reservaTipo2: reservasBoletos
            ) {
                reservaTipo2.aplicarDescuento(0.95);
            }
        }

    }

    public void calcularTotal(){
        total = reserva.stream().mapToDouble(Reserva::getMonto).sum();
        double multiplicadorDescuento = 0;
        if(cliente.getLocalizadores().size()>=2){
            multiplicadorDescuento = 5.0/100;
        }
        total = total-total*multiplicadorDescuento;
        DescuentoPaqueteCompleto();
    }

    private void DescuentoPaqueteCompleto(){
        for(int i = 0; i<reserva.size(); i++){
            if(reserva.get(i) instanceof ReservaPaqueteCompleto){
                total = total*0.9;
                break;
            }
        }
    }

}
