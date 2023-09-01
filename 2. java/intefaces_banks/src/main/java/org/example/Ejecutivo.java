package org.example;

public class Ejecutivo extends Cliente{

    @Override
    public void realizarTransaccion(Transaccion transaccion) {
        if(transaccion instanceof Deposito || transaccion instanceof Transferencia){
            transaccion.transaccionOk();
        }else{
            transaccion.transaccionNoOk();
        }
    }

}
