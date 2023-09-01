package org.meli;

public class ConsultaSaldo implements Transaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Su saldo es de $100");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("No tiene permisos para realizar la accion");
    }
}
