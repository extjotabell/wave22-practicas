package org.example;

public class RetiroDeEfectivo implements Transaccion{

    @Override
    public void transaccionOk() {
        System.out.println("Retiro de efectivo realizado");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("No pudo realizarse el retiro de efectivo");
    }
}
