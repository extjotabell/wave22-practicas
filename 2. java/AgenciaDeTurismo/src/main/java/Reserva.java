public class Reserva {
    public enum tipoReserva {
        HOTEL,
        COMIDA,
        VIAJE,
        TRANSPORTE
    }
    tipoReserva tipo;
    String descripcion;

    public Reserva(tipoReserva tipo, String descripcion, double costo) {
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.costo = costo;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    double costo;

    public tipoReserva getTipo() {
        return tipo;
    }

    public void setTipo(tipoReserva tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
