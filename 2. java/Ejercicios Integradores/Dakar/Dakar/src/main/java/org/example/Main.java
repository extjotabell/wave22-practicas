package org.example;

public class Main {
    public static void main(String[] args) {
        Carrera carrera = new Carrera(2,2, "pep", 5);
        SocorristaAuto socorristaAuto = new SocorristaAuto(5, 3, 180, "AFR345", 120, 4);
        SocorristaMoto socorristaMoto = new SocorristaMoto(5, 3, 180, "URI845", 70, 4);
        carrera.darDeAltaAuto(2,2,2,"222");
        carrera.darDeAltaMoto(1,1,1,"111");
        carrera.eliminarVehiculoConPatente("11");

        socorristaAuto.socorrer((Auto) carrera.getVehiculos().get(0));
        socorristaMoto.socorrer((Moto) carrera.getVehiculos().get(1));
        carrera.socorrer("111");

        carrera.determinarGanador();

    }
}