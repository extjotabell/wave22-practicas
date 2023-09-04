package domain;

import java.util.List;

public class Reserva {
    private Cliente cliente;
    private String hotel;
    private String comida;
    private Integer boletosDeViaje;
    private String transporte;

    public Reserva(Cliente cliente, String hotel, String comida, Integer boletosDeViaje, String transporte) {
        this.cliente = cliente;
        this.hotel = hotel;
        this.comida = comida;
        this.boletosDeViaje = boletosDeViaje;
        this.transporte = transporte;
        descuentoCliente(cliente);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public String getComida() {
        return comida;
    }

    public void setComida(String comida) {
        this.comida = comida;
    }

    public Integer getBoletosDeViaje() {
        return boletosDeViaje;
    }

    public void setBoletosDeViaje(Integer boletosDeViaje) {
        this.boletosDeViaje = boletosDeViaje;
    }

    public String getTransporte() {
        return transporte;
    }

    public void setTransporte(String transporte) {
        this.transporte = transporte;
    }

    public void descuentoCliente(Cliente cliente) {
        if (cliente.getPaquete() != null) {
            cliente.setDescuento(0.10);
        }
        else if(cliente.getPaquete().quantityReservas > 1) {
            cliente.setDescuento(0.05);
        }
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "cliente=" + cliente +
                ", hotel='" + hotel + '\'' +
                ", comida='" + comida + '\'' +
                ", boletosDeViaje=" + boletosDeViaje +
                ", transporte='" + transporte + '\'' +
                '}';
    }
}
