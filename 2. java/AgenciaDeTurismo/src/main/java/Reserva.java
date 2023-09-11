public class Reserva {

    TipoReserva tipo;
    String descripcion;

    public Reserva(TipoReserva tipo, String descripcion, double costo) {
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

    public TipoReserva getTipo() {
        return tipo;
    }

    public void setTipo(TipoReserva tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
