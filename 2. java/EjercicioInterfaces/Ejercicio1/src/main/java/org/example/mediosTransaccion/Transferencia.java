package org.example.mediosTransaccion;

public class Transferencia implements Transaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Transferencia realizada existosamente");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("No tiene permisos para realizar la accion");
    }
}
