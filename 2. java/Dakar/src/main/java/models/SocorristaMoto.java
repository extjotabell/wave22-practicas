package models;

public class SocorristaMoto extends Vehiculo implements Socorre<Moto> {

    @Override
    public void socorrer(Moto vehiculoASocorrer) {
        System.out.println("Socorriendo Moto con patente: " + vehiculoASocorrer.getPatente());
    }
}
