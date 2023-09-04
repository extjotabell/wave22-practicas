import java.util.ArrayList;
public class Reserva {
    double costo;
    String tipo; //hotel, comida, boletos de viaje, transporte
    String Nombre; // nombre del hotel, comida, etc

    boolean paquete_completo = false;

    public Reserva(double costo, String tipo, String nombre) {
        this.costo = costo;
        this.tipo = tipo;
        Nombre = nombre;
    }

    public Reserva(double costo, String tipo, String nombre, boolean paquete_completo) {
        this.costo = costo;
        this.tipo = tipo;
        Nombre = nombre;
        this.paquete_completo = paquete_completo;
    }

    public String getTipo() {
        return tipo;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }
}
