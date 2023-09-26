package Models;

import Repositories.LocalizadorRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AgenciaViaje implements LocalizadorRepository {
    private String nombre;
    private List<Localizador> localizador;

    public AgenciaViaje(String nombre) {
        this.nombre = nombre;
        this.localizador = new ArrayList<Localizador>();
    }

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

        for(Localizador localizador : this.localizador){
            final double[] descuento = {0};
            final double[] precioAcumulado = {0};
            List<PaqueteTuristico> paquete = localizador.getPaqueteTuristico();
            paquete.forEach(
                    paqueteTuristico ->
                    {
                        descuento[0] += 0;
                        descuento[0] += !paqueteTuristico.isTransporte() && paqueteTuristico.getNroBoleto().size() >= 2 ? 5 : 0;
                        descuento[0] += paqueteTuristico.isTransporte() ? 10 : 0;
                        precioAcumulado[0] += paqueteTuristico.getPrecio();
                    }
            );
            descuento[0] += paquete.size() >= 2 ? 5 : 0;
            System.out.println(localizador.getPersona().toString() + ": Precio final " + (precioAcumulado[0] -  (precioAcumulado[0] * descuento[0]/ 100)) + " - Descuento: " + descuento[0] + " - Informacion del paquete: " + paquete.toString());
        }
    }

    @Override
    public void crear(Localizador localizador) {
        this.localizador.add(localizador);
    }
}