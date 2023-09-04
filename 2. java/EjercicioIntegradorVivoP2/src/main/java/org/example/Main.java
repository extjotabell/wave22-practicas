package org.example;

import Models.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        PaqueteTuristico paquete1 =new PaqueteTuristico(300, List.of(new Integer[]{1}), List.of(new String[]{"CCVASD123"}));
        PaqueteTuristico paquete2 = new PaqueteTuristico(2000, List.of(new Integer[]{23,54}),  List.of(new String[]{"bol2", "bol3"}),true,true);

        AgenciaViaje agencia = new AgenciaViaje("Agencia turistica");
        agencia.crear(new Localizador(
                new Persona("Lulu", 38832625),
                List.of(
                        paquete1, paquete2
                )
        ));
        agencia.crear(new Localizador(
                new Persona("Solange", 35756263),
                List.of(paquete2)
        ));
        agencia.crear(new Localizador(
                new Persona("Iara", 54355654),
                List.of(paquete1)
        ));


        agencia.aplicarDescuento();
    }
}