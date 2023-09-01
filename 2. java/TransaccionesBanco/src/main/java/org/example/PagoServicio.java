package org.example;

public class PagoServicio implements Transaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Se pudo pagar servicio");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("No se pudo pagar servicio");
    }
}
