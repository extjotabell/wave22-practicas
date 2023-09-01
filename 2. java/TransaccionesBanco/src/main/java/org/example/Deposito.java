package org.example;

public class Deposito implements Transaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Se pudo depositar");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("No se pudo depositar");
    }
}
