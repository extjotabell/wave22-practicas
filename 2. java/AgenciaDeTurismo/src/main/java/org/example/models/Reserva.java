package org.example.models;

public class Reserva {
    private int reservasDeHotel;
    private int comidas;
    private int boletosViaje;
    private int transportes;

    public Reserva(int reservasDeHotel, int comidas, int boletosViaje, int transportes) {
        this.reservasDeHotel = reservasDeHotel;
        this.comidas = comidas;
        this.boletosViaje = boletosViaje;
        this.transportes = transportes;
    }

    public Reserva() {
    }

    public int getReservasDeHotel() {
        return reservasDeHotel;
    }

    public void setReservasDeHotel(int reservasDeHotel) {
        this.reservasDeHotel = reservasDeHotel;
    }

    public int getComidas() {
        return comidas;
    }

    public void setComidas(int comidas) {
        this.comidas = comidas;
    }

    public int getBoletosViaje() {
        return boletosViaje;
    }

    public void setBoletosViaje(int boletosViaje) {
        this.boletosViaje = boletosViaje;
    }

    public int getTransportes() {
        return transportes;
    }

    public void setTransportes(int transportes) {
        this.transportes = transportes;
    }

    public double totalReserva(){
        return (reservasDeHotel * 1000 + comidas * 200 + boletosViaje * 100 + transportes * 200);
    }

    public boolean esCompleta(){
        return (reservasDeHotel > 0 && comidas > 0 && boletosViaje > 0 && transportes > 0);
    }

    public boolean aplicarTercerDescuento(){
        return (reservasDeHotel >= 2 || boletosViaje >= 2 );
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "reservasDeHotel=" + reservasDeHotel +
                ", comidas=" + comidas +
                ", boletosViaje=" + boletosViaje +
                ", transportes=" + transportes +
                ", total: " + totalReserva() +
                '}';
    }
}
