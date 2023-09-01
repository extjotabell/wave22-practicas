package org.example;

public class Basic implements ConsultaSaldo {
    @Override
    public void consultarSaldo() {
        System.out.println("Consultando saldo");
    }

    @Override
    public void transaccionOk() {

    }

    @Override
    public void transaccionNoOk() {

    }
}
