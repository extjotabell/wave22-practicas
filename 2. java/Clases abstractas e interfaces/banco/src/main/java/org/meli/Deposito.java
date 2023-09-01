package org.meli;

public class Deposito implements Transaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Deposito realizado existosamente");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("No tiene permisos para realizar la accion");
    }
}
