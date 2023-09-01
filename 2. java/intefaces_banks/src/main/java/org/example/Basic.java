package org.example;

public class Basic extends Cliente{

    @Override
    public void realizarTransaccion(Transaccion transaccion) {
        if(transaccion instanceof ConsultaSaldo || transaccion instanceof PagoServicio || transaccion instanceof RetiroEfectivo){
            transaccion.transaccionOk();
        }else{
            transaccion.transaccionNoOk();
        }
    }
}
