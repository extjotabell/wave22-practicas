import java.util.ArrayList;
import java.util.List;
public class Carrera {
    double distancia;
    double premioEnDolares;
    String nombre;
    double cantDeVehiculos;
    List<Vehiculo> vehiculos;

    List<Vehiculo> socorristas;

    public Carrera(double distancia, double premioEnDolares, String nombre) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.vehiculos = new ArrayList<>();
        this.socorristas = new ArrayList<>();
    }

    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente){
        Auto auto = new Auto(velocidad, aceleracion, anguloDeGiro, patente);
        this.vehiculos.add(auto);
    }

    public void darDeAltaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente){
        Moto moto = new Moto(velocidad, aceleracion, anguloDeGiro, patente);
        this.vehiculos.add(moto);
    }

    public void darDeAltaSocorristaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente, double peso, int ruedas){
        SocorristaAuto socorrista = new SocorristaAuto(velocidad, aceleracion, anguloDeGiro, patente, peso, ruedas);
        this.socorristas.add(socorrista);
    }

    public void darDeAltaSocorristaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente, double peso, int ruedas){
        SocorristaMoto socorrista = new SocorristaMoto(velocidad, aceleracion, anguloDeGiro, patente, peso, ruedas);
        this.socorristas.add(socorrista);
    }

    public void eliminarVehiculo(Vehiculo vehiculo){
        this.vehiculos.remove(vehiculo);
    }

    public void eliminarVehiculoConPatente(String unaPatente){
        int count = 0;
        for (Vehiculo vehiculo : vehiculos) {
            if (unaPatente == vehiculo.getPatente()) {
                this.vehiculos.remove(count);
            }
            count+=1;
        }
    }

    public Vehiculo encontrarGanador(){
        // Si hay solo un vehiculo gana ese
        Vehiculo ganador = this.vehiculos.get(0);
        double mayor = 0;
        for (Vehiculo vehiculo : this.vehiculos){
            double puntaje;
            double numerador = vehiculo.getVelocidad()* 1/2 * vehiculo.getAceleracion();
            double denominador = vehiculo.getAnguloDeGiro()*(vehiculo.getPeso()-vehiculo.getRuedas()*100);
            puntaje = numerador / denominador;
            if (puntaje > mayor) {
                ganador = vehiculo;
            }
        }
        return ganador;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public List<Vehiculo> getSocorristas() {
        return socorristas;
    }
}
