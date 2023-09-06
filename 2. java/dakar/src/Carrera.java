import java.util.ArrayList;
import java.util.List;
public class Carrera {
    private double distancia;
    private double premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private List<Vehiculo> listaDeVehiculos;

    public Carrera(double distancia, double premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.listaDeVehiculos = new ArrayList<>();
    }

    public void darDeAltaAuto (double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        if(listaDeVehiculos.size() < cantidadDeVehiculosPermitidos) {
            listaDeVehiculos.add(new Autos(velocidad, aceleracion, anguloDeGiro, patente, 1000, 4));
        } else {
            System.out.println("No hay cupo para esta carrera");
        }

    }
    public void darDeAltaMoto (double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        if(listaDeVehiculos.size() < cantidadDeVehiculosPermitidos) {
            listaDeVehiculos.add(new Motos(velocidad, aceleracion, anguloDeGiro, patente, 300, 2));
        } else {
            System.out.println("No hay cupo para esta carrera");
        }
    }

    public void eliminarVehiculo (Vehiculo vehiculo){
        listaDeVehiculos.remove(vehiculo);
    }

    public void eliminarVehiculoConPatente (String patente){
        for (Vehiculo vehiculo:listaDeVehiculos) {
            if (vehiculo.getPatente().equals(patente)) {
                listaDeVehiculos.remove(vehiculo);
                break;
            }
        }
    }


    public Vehiculo ganadorCarrera (){
        Vehiculo vehiculoGanador = null;
        double tiempoCarrera = 0;
        for (Vehiculo vehiculo: listaDeVehiculos) {
            double calculoVehiculo = (vehiculo.getVelocidad() * 0.5 * vehiculo.getAceleracion()) / (vehiculo.getAnguloDeGiro() * (vehiculo.getPeso() - (vehiculo.getRuedas() * 100)));
            if (calculoVehiculo > tiempoCarrera) {
                tiempoCarrera = calculoVehiculo;
                vehiculoGanador = vehiculo;
            }
        }
        return vehiculoGanador;
    }

    public Vehiculo encontrarVehiculoPorPatente(String patente) {
        Vehiculo vehiculoEncontrado = null;
        for (Vehiculo vehiculo: listaDeVehiculos) {
            if (vehiculo.getPatente().equals(patente)) {
                vehiculoEncontrado = vehiculo;
            }
        }
        return vehiculoEncontrado;
    }

    public void socorrerVehiculo(Socorrista socorrista, String patente) {
        Vehiculo vehiculoEncontrado = encontrarVehiculoPorPatente(patente);
        if (vehiculoEncontrado == null){
            System.out.println("No se encontro el vehiculo");
            return;
        }
        socorrista.socorrer(vehiculoEncontrado);
    }
}
