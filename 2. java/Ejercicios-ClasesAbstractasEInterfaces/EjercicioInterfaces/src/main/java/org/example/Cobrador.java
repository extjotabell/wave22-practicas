package org.example;

public class Cobrador extends Cliente{
    @Override
    public void realizarTransaccion(Transaccion transaccion) {
        System.out.println("Cliente Cobrador realizando transaccion " + transaccion.getClass().getSimpleName());
        if(transaccion instanceof RetirarEfectivo || transaccion instanceof ConsultaSaldo)
            transaccion.transaccionOk();
        else
            transaccion.transaccionNoOk();
    }
}
