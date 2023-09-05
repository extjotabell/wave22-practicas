import java.util.ArrayList;
import java.util.List;

public class Carrera {
    private Double distancia;
    private Double premio;
    private String nombre;
    private Integer cantidadDeVehiculosPermitidos;
    private List<Vehiculo> listaDeVehiculos;
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    public Carrera(Double distancia, Double premio, String nombre, Integer cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premio = premio;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.listaDeVehiculos = new ArrayList<>();
        this.socorristaAuto = new SocorristaAuto();
        this.socorristaMoto = new SocorristaMoto();
    }

    public void darDeAltaAuto(Integer velocidad, Integer aceleracion, Double anguloDeGiro, String patente){
        if(listaDeVehiculos.size() < cantidadDeVehiculosPermitidos){
            Auto auto = new Auto(velocidad, aceleracion, anguloDeGiro, patente);
            listaDeVehiculos.add(auto);
        }else{
            System.out.println("La carrera esta llena");
        }
    }

    public void darDeAltaMoto(Integer velocidad, Integer aceleracion, Double anguloDeGiro, String patente){
        if(listaDeVehiculos.size() < cantidadDeVehiculosPermitidos){
            Moto moto = new Moto(velocidad, aceleracion, anguloDeGiro, patente);
            listaDeVehiculos.add(moto);
        }else{
            System.out.println("La carrera esta llena");
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo){
        listaDeVehiculos.remove(vehiculo);
    }

    public void eliminarVehiculConPatente(String patente){
        Vehiculo vehiculoBuscado = null;
        for(Vehiculo vehiculo: this.listaDeVehiculos){
            if(vehiculo.getPatente() == patente){
                vehiculoBuscado = vehiculo;
                break;
            }
        }

        if(vehiculoBuscado != null){
            listaDeVehiculos.remove(vehiculoBuscado);
        }else{
            System.out.println("Vehiculo no encontrado!");
        }
    }

    public void socorrerAuto(String patente){
        for(Vehiculo vehiculo : listaDeVehiculos){
            if(vehiculo.getPatente().equals(patente)) socorristaAuto.socorrer((Auto)vehiculo);
        }
    }

    public void socorrerMoto(String patente){
        for(Vehiculo vehiculo : listaDeVehiculos){
            if(vehiculo.getPatente().equals(patente)) socorristaMoto.socorrer((Moto)vehiculo);
        }
    }

    public Vehiculo definirGanador() {
        if (listaDeVehiculos.isEmpty()) {
            System.out.println("No hay vehículos en la carrera.");
            return null;
        }

        Vehiculo vehiculoGanador = listaDeVehiculos.get(0); // Supongamos que el primer vehículo es el ganador inicialmente
        double puntuacionMaxima = calcularPuntuacion(vehiculoGanador);

        for (Vehiculo vehiculo : listaDeVehiculos) {
            double puntuacionActual = calcularPuntuacion(vehiculo);

            if (puntuacionActual > puntuacionMaxima) {
                vehiculoGanador = vehiculo;
                puntuacionMaxima = puntuacionActual;
            }
        }

        return vehiculoGanador;
    }

    private double calcularPuntuacion(Vehiculo vehiculo) {
        // Calcula la puntuación utilizando la fórmula dada Velocidad * ½ Aceleracion / (AnguloDeGiro * (Peso - CantidadDeRuedas * 100))
        return vehiculo.getVelocidad() * 0.5 * vehiculo.getAceleracion() / (vehiculo.getAnguloDeGiro() * (vehiculo.getPeso() - vehiculo.getRuedas() * 100));
    }


}
