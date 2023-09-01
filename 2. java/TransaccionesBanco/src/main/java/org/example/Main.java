package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Cobrador cobrador = new Cobrador();
        Basic basic = new Basic();
        Ejecutivo ejecutivo = new Ejecutivo();

        List<Transaccion> listaTransacciones = new ArrayList<>();

        listaTransacciones.add(new ConsultaSaldo());
        listaTransacciones.add(new Deposito());
        listaTransacciones.add(new RetiroEfectivo());
        listaTransacciones.add(new Transferencia());

        // Test pagoServicio como Transaccion, instanciandolo como PagoServicio
        Transaccion pagoServicio = new PagoServicio();

        // Testear todas las transacciones con todos los clientes:
        System.out.println("\n");
        listaTransacciones.forEach(t-> {
            System.out.println("Test Cobrador con transaccion: " + t.getClass().getSimpleName());
            cobrador.hacerTransaccion(t);

            System.out.println("Test Basic haciendo transaccion: " + t.getClass().getSimpleName());
            basic.hacerTransaccion(t);

            System.out.println("Test Ejecutivo haciendo transaccion: " + t.getClass().getSimpleName());
            ejecutivo.hacerTransaccion(t);

            System.out.println("\n");
        });
    }
}