import javax.swing.plaf.basic.BasicScrollPaneUI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public  class Carrera {
     int Distancia;
     int PremioEnDolares;
     String Nombre;
     int CantidadPermitida;
     List<Vehiculo> vehiculos = new ArrayList<>();
     SocorristaAuto socorristaAuto;
     SocorristaMoto socorristaMoto;

    public Carrera(int distancia, int premioEnDolares, String nombre, int cantidadPermitida) {
        Distancia = distancia;
        PremioEnDolares = premioEnDolares;
        Nombre = nombre;
        CantidadPermitida = cantidadPermitida;
    }

    public int getDistancia() {
        return Distancia;
    }

    public void setDistancia(int distancia) {
        Distancia = distancia;
    }

    public int getPremioEnDolares() {
        return PremioEnDolares;
    }

    public void setPremioEnDolares(int premioEnDolares) {
        PremioEnDolares = premioEnDolares;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getCantidadPermitida() {
        return CantidadPermitida;
    }

    public void setCantidadPermitida(int cantidadPermitida) {
        CantidadPermitida = cantidadPermitida;
    }
    public void darDeAltaAuto(Auto auto){
        if(vehiculos.size() < getCantidadPermitida()){
            vehiculos.add(auto);
        }
    }
    public void darDeAltaMoto(Moto moto){
        if(vehiculos.size() < getCantidadPermitida()){
            vehiculos.add(moto);
        }
    }
    public void eliminarVehiculo(Vehiculo vehiculo){
        vehiculos.remove(vehiculo);
    }
    public void eliminarVehiculoConPatente(String patente){
        vehiculos.removeIf(x->x.getPatente().equals(patente));
    }
    public SocorristaAuto getSocorristaAuto() {
        return socorristaAuto;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public void setSocorristaAuto(SocorristaAuto socorristaAuto) {
        this.socorristaAuto = socorristaAuto;
    }

    public SocorristaMoto getSocorristaMoto() {
        return socorristaMoto;
    }

    public void setSocorristaMoto(SocorristaMoto socorristaMoto) {
        this.socorristaMoto = socorristaMoto;
    }
    public void socorrerAuto(String patente){
        Optional<Vehiculo> auto = vehiculos.stream()
                .filter(x->x.getPatente().equals(patente))
                .findFirst();
        if(auto.isEmpty()){
            System.out.println("No existe el auto");
        }
        else if(auto.getClass().equals(Auto.class)){
            getSocorristaAuto().socorrer((Auto) auto.get());
        }
    }
    public void socorrerMoto(String patente){
        Optional<Vehiculo> moto = vehiculos.stream()
                .filter(x->x.getPatente().equals(patente))
                .findFirst();
        if(moto.isEmpty()){
            System.out.println("No existe la Moto");
        }
        else if(moto.getClass().equals(Moto.class)){
            getSocorristaMoto().socorrer((Moto) moto.get());
        }
    }
}
