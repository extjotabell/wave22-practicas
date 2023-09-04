package org.example;

public class RetirarEfectivo implements Transaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Retiro de efectivo relizado exitosamente");
    }

    @Override
    public void transaccionNoOk() {
            System.out.println("No tiene permisos para realizar la accion");
    }
}
