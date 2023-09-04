package org.example;

public class Main {
    public static void main(String[] args) {
        Ejecutivo ejecutivo = new Ejecutivo();

        ejecutivo.realizarTransaccion(new ConsultaSaldo());
        ejecutivo.realizarTransaccion(new Transferencia());
        ejecutivo.realizarTransaccion(new Deposito());

        Basic basic = new Basic();
        basic.realizarTransaccion(new PagoServicios());
        basic.realizarTransaccion(new RetirarEfectivo());
        basic.realizarTransaccion(new ConsultaSaldo());

        Cobrador cobrador = new Cobrador();
        cobrador.realizarTransaccion(new RetirarEfectivo());
        cobrador.realizarTransaccion(new PagoServicios());
        cobrador.realizarTransaccion(new ConsultaSaldo());
    }
}