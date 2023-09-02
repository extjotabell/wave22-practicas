package com.renzobayarri;

public class RetiroEfectivo implements Transaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Retiro realizado");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Retiro no realizado");
    }
}
