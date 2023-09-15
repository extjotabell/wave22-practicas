package org.example;

public class Main {
    public static void main(String[] args) {

        System.out.println("Cliente Basico");
        Cliente client1 = new Basic();
        Transaccion transaction1 = new RetiroDeEfectivo();
        Transaccion transaction2 = new RetiroDeEfectivo();
        client1.realizarTransaccion(transaction1);
        client1.realizarTransaccion(transaction2);
        System.out.println("");

        System.out.println("Cliente Ejecutivo");
        Cliente client2 = new Ejecutivo();
        Transaccion transaction3 = new Deposito();
        client2.realizarTransaccion(transaction3);
        client2.realizarTransaccion(transaction1);
        System.out.println("");

        System.out.println("Cliente Cobrador");
        Cliente client3 = new Cobrador();
        Transaccion transaction4 = new ConsultaDeSaldo();
        client3.realizarTransaccion(transaction4);
    }
}