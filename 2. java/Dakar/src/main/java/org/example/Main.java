package org.example;

import org.example.Vehiculos.Auto;
import org.example.Vehiculos.Moto;
import org.example.Vehiculos.Vehiculo;

public class Main {
    public static void main(String[] args) {

        Carrera carrera = new Carrera(50.0, 1000.0, "Carrera loca", 5);
        Vehiculo v = new Auto(100,10,10,"123ABC");
        Vehiculo v1 = new Moto(50,40,10,"456DEF");
        Vehiculo v2 = new Auto(120,10,50,"789ABC");
        Vehiculo v3 = new Moto(70,20,35,"123DEF");

        carrera.darDeAltaAuto(v.getVelocidad(), v.getAceleracion(), v.getAnguloGiro(), v.getPatente());
        carrera.darDeAltaMoto(v1.getVelocidad(), v1.getAceleracion(), v1.getAnguloGiro(), v1.getPatente());
        carrera.darDeAltaAuto(v2.getVelocidad(), v2.getAceleracion(), v2.getAnguloGiro(), v2.getPatente());
        carrera.darDeAltaAuto(v3.getVelocidad(), v3.getAceleracion(), v3.getAnguloGiro(), v3.getPatente());
        carrera.eliminarVehiculoXPatente("123ABC");

        carrera.definirGanador();

    }
}