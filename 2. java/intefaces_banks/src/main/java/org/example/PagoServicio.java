package org.example;

public class PagoServicio implements Transaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Servicio Pagado");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Servicio no pagado");
    }
}
