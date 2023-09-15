package org.example;

public class ConsultaDeSaldo implements Transaccion{

    @Override
    public void transaccionOk() {
        System.out.println("Su saldo está ok");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("No se pudo consultar su saldo");
    }
}
