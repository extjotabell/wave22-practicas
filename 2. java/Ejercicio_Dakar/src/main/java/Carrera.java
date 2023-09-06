import java.util.ArrayList;
import java.util.List;

public class Carrera {

    int distancia;
    double premioEnDolares;
    String nombre;
    int cantidadVehiculosPermitidos;

    List<Vehiculo> listaDeVehiculos = new ArrayList<>();
    SocorristaMoto socorristaMoto;
    SocorristaAuto socorristaAuto;

    public void darDeAltaAuto(int velocidad, int aceleracion, int anguloDeGiro, String patente){
        listaDeVehiculos.add(new Auto(velocidad,aceleracion,anguloDeGiro,patente));
    }
    public void darDeAltaMoto(int velocidad, int aceleracion, int anguloDeGiro, String patente){
        listaDeVehiculos.add(new Moto(velocidad,aceleracion,anguloDeGiro,patente));
    }
    public void eliminarVehiculo(Vehiculo vehiculo){
        listaDeVehiculos.remove(vehiculo);
    }
    public void eliminarVehiculoConPatente(String patente){
        listaDeVehiculos.removeIf(v -> v.getPatente() == patente);
    }

    public Vehiculo definirGanador(){
        double max = 0;
        Vehiculo vehiculoGanador = null;

        for (Vehiculo v: listaDeVehiculos) {
            double aux = v.getVelocidad()*0.5/(v.getAnguloDeGiro()*(v.getPeso()-v.getRuedas()*100));
            if( aux >= max){
                vehiculoGanador = v;
                max = aux;
            }
        }
        return vehiculoGanador;
    }

    public void SocorrerAuto(String patente){
        System.out.println("Socorriendo auto: " + patente);
    }
    public void SocorrerMoto(String patente){
        System.out.println("Socorriendo moto: " + patente);
    }
}
