package main;

public class Main {

    public static void main(String[] args) {
        Vehiculo v1 = new Vehiculo(100, 200, 5, "ASD1");
        Vehiculo v2 = new Vehiculo(150, 100, 4, "ASD2");
        Vehiculo v3 = new Vehiculo(150, 100, 4, "ASD");
        Vehiculo v4 = new Vehiculo(120, 300, 3, "ASD4");

        Carrera c1 = new Carrera(200, 1000, "Carrera 1", 3);
        c1.darDeAltaAuto(100, 200, 5, "ASD1");
        c1.darDeAltaAuto(1500, 100, 4, "ASD2");
        c1.darDeAltaAuto(250, 90, 4, "ASD3");
        c1.darDeAltaAuto(120, 300, 3, "ASD4");

        c1.determinarGanador();
        c1.socorrerAuto("ASD1");
    }
}
