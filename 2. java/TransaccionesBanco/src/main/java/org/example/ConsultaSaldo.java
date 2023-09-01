package org.example;

public class ConsultaSaldo implements Transaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Se pudo consultar Saldo");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("No se pudo consultar Saldo");
    }
}
