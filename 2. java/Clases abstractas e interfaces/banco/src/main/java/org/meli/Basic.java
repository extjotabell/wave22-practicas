package org.meli;

public class Basic extends Cliente{
    @Override
    public void realizarTransaccion(Transaccion transaccion) {
        if(transaccion instanceof ConsultaSaldo || transaccion instanceof PagoServicios || transaccion instanceof RetirarEfectivo)
            transaccion.transaccionOk();
        else
            transaccion.transaccionNoOk();
    }
}
