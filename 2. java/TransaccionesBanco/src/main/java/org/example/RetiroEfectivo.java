package org.example;

public class RetiroEfectivo implements Transaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Se pudo retirar efectivo");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("No se pudo retirar efectivo");

    }
}
