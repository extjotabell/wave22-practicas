package org.example;

public class Main {
    public static void main(String[] args) {

        Cliente ejecutivo = new Ejecutivo();
        Cliente basic = new Basic();
        Cliente cobrador = new Cobrador();

        Transaccion deposito = new Deposito();
        Transaccion transferencia = new Transferencia();
        Transaccion retiroEfectivo = new RetiroEfectivo();
        Transaccion pagoServicio = new PagoServicio();
        Transaccion consultaSaldo = new ConsultaSaldo();

        System.out.println("Operaciones ejecutivo");
        ejecutivo.realizarTransaccion(deposito);
        ejecutivo.realizarTransaccion(transferencia);
        ejecutivo.realizarTransaccion(retiroEfectivo);
        ejecutivo.realizarTransaccion(pagoServicio);
        ejecutivo.realizarTransaccion(consultaSaldo);
        System.out.println("");

        System.out.println("Operaciones basic");
        basic.realizarTransaccion(deposito);
        basic.realizarTransaccion(transferencia);
        basic.realizarTransaccion(retiroEfectivo);
        basic.realizarTransaccion(pagoServicio);
        basic.realizarTransaccion(consultaSaldo);
        System.out.println("");

        System.out.println("Operaciones cobrador");
        cobrador.realizarTransaccion(deposito);
        cobrador.realizarTransaccion(transferencia);
        cobrador.realizarTransaccion(retiroEfectivo);
        cobrador.realizarTransaccion(pagoServicio);
        cobrador.realizarTransaccion(consultaSaldo);
        System.out.println("");

    }
}