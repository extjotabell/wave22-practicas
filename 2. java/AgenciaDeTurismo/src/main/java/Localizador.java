import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Localizador {
    Cliente cliente;
    List<Reserva> reservas;
    double costo;

    public Localizador(Cliente cliente, List<Reserva> reservas) {
        this.cliente = cliente;
        this.reservas = reservas;
        calcularCosto();
    }
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    private void calcularCosto(){
        boolean descViaje = reservas.stream().filter(x->x.tipo == Reserva.tipoReserva.VIAJE).count() >= 2;
        boolean descHotel = reservas.stream().filter(x->x.tipo == Reserva.tipoReserva.HOTEL).count() >= 2;
        double costoSinDescuentos = reservas.stream().mapToDouble(x -> x.costo).sum();
        costo = costoSinDescuentos;
        if(Repositorio.localizadores.stream().filter(x->x.cliente == cliente).count() >= 2){
            costo -= (costoSinDescuentos*5)/100;
        }
        if(reservas.stream().collect(Collectors.groupingBy(Reserva::getTipo)).size() == 4){
            costo -= (costoSinDescuentos*10)/100;
        }
        if(descViaje){
            double descPorViaje = reservas.stream()
                    .filter(x->x.tipo == Reserva.tipoReserva.VIAJE).mapToDouble(x -> x.costo).sum()/20;
            costo -= descPorViaje;
        }
        if(descHotel) {
            double descPorHotel = reservas.stream()
                    .filter(x -> x.tipo == Reserva.tipoReserva.HOTEL).mapToDouble(x -> x.costo).sum() / 20;
            costo -= descPorHotel;
        }
    }

    public void save(){
        Repositorio.localizadores.add(this);
    }
}
