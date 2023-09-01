package org.example;

public class ConsultaSaldo implements Transaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Consulta de saldos realizada");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Consulta de saldos no realizada");
    }
}
