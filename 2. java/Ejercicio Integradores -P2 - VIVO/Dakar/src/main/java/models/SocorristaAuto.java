package models;

public class SocorristaAuto extends Vehiculo implements Socorre<Auto>{

    @Override
    public void socorrer(Auto vehiculoASocorrer) {
        System.out.println("Socorriendo Auto con patente: " + vehiculoASocorrer.getPatente());
    }
}
