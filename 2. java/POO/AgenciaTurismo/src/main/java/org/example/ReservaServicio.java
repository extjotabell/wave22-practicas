package org.example;

public class ReservaServicio extends Reserva{
    private String tipoReserva;

    public ReservaServicio(int id, double monto, String fechaEntradaSalida, String tipoReserva) {
        super(id, monto, fechaEntradaSalida);
        this.tipoReserva = tipoReserva;
    }

    public String getTipoReserva() {
        return tipoReserva;
    }
}
