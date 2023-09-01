package org.meli;

public class Cobrador extends Cliente{
    @Override
    public void realizarTransaccion(Transaccion transaccion) {
        if(transaccion instanceof RetirarEfectivo || transaccion instanceof ConsultaSaldo)
            transaccion.transaccionOk();
        else
            transaccion.transaccionNoOk();
    }
}
