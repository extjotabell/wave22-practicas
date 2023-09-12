package Models;

import Repositorios.LocalizadorRepository;

import java.util.List;
import java.util.stream.Collectors;

public class AgenciaViaje implements LocalizadorRepository {
    private String nombre;
    private List<Localizador> localizador;

    public AgenciaViaje(String nombre, List<Localizador> localizador) {
        this.nombre = nombre;
        this.localizador = localizador;
    }

    public List<Localizador> getLocalizador() {
        return localizador;
    }

    public void setLocalizador(List<Localizador> localizador) {
        this.localizador = localizador;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public void aplicarDescuento() {
        //List<List<PaqueteTuristico>> paquete = this.localizador.stream().map(Localizador::getPaqueteTuristico).collect(Collectors.toList());
        //List<PaqueteTuristico> paqueteSimple = this.localizador.stream().map(x -> x.getPaqueteTuristico().stream().filter(
        //        y -> y.getReserva().stream().)).collect(Collectors.toList());

        for(Localizador localizador : this.localizador){
            int descuento = 0;
            double precioFinal = 0;
            List<PaqueteTuristico> paquete = localizador.getPaqueteTuristico();
            if (paquete.size() >= 2) descuento+=5;
            for (PaqueteTuristico p : paquete){
                descuento+= p.isTransporte() == true  ? 10 : 0;
                descuento+= !p.isTransporte() && p.getNroBoleto().size() >= 2  ? 5 : 0;
                precioFinal+=p.getPrecio();
            }
            precioFinal = precioFinal - (precioFinal*descuento/100);
            System.out.println(localizador.toString());
            System.out.println(localizador.getPersona().toString() + ": " + precioFinal + " ,Descuento:" + descuento);
        }
    }

    @Override
    public void crear(Localizador localizador) {
        this.localizador.add(localizador);
    }
}
