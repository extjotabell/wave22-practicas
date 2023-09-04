package org.example;

public class Ejecutivo extends Cliente{
    @Override
    public void realizarTransaccion(Transaccion transaccion) {
        System.out.println("Cliente Ejecutivo realizando transaccion " + transaccion.getClass().getSimpleName());
        if(transaccion instanceof Deposito || transaccion instanceof Transferencia)
            transaccion.transaccionOk();
        else
            transaccion.transaccionNoOk();
    }
}
