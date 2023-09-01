package org.example;

public class Transferencia implements Transaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Se pudo transferir");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("No se pudo transferir");
    }
}
