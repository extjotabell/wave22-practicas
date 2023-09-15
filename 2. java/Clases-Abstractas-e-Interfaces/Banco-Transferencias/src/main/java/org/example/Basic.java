package org.example;

public class Basic extends Cliente{

    @Override
    public void realizarTransaccion(Transaccion transaccion) {
        if (transaccion instanceof ConsultaDeSaldo || transaccion instanceof PagoDeServicio || transaccion instanceof RetiroDeEfectivo){
            transaccion.transaccionOk();
        } else {
            transaccion.transaccionNoOk();
        }
    }
}
