package org.example;

public class PagoDeServicio implements Transaccion{

    @Override
    public void transaccionOk() {
        System.out.println("Pago de servicio realizado");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Pago de servicio no se pudo realizar");
    }
}
