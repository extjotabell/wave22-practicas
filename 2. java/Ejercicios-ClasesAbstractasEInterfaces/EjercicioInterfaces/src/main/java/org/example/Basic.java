package org.example;

public class Basic extends Cliente{
    @Override
    public void realizarTransaccion(Transaccion transaccion) {
        System.out.println("Cliente Basic realizando transaccion " + transaccion.getClass().getSimpleName());
        if(transaccion instanceof ConsultaSaldo || transaccion instanceof PagoServicios || transaccion instanceof RetirarEfectivo)
            transaccion.transaccionOk();
        else
            transaccion.transaccionNoOk();
    }
}
