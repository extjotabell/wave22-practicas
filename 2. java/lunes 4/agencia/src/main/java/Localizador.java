import java.util.ArrayList;

public class Localizador {


    private Cliente datosCliente;
    private double total;
    private ArrayList<Reserva> reservas;

    public Localizador(Cliente datosCliente, ArrayList<Reserva> reservas) {
        this.datosCliente = datosCliente;
        this.reservas = reservas;
    }

    public Cliente getDatosCliente() {
        return datosCliente;
    }

    public void setDatosCliente(Cliente datosCliente) {
        this.datosCliente = datosCliente;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(ArrayList<Reserva> reservas) {
        this.reservas = reservas;
    }

    public double calcularTotal(){

        return total = reservas.stream()
                .mapToDouble(Reserva::getPrecio)
                .sum();
    }

}
