package org.example.clientes;

import org.example.mediosTransaccion.Transaccion;
import org.example.mediosTransaccion.ConsultaSaldo;
import org.example.mediosTransaccion.PagoServicios;
import org.example.mediosTransaccion.RetirarEfectivo;

public class Basic extends Cliente {
    @Override
    public void realizarTransaccion(Transaccion transaccion) {
        if(transaccion instanceof ConsultaSaldo || transaccion instanceof PagoServicios || transaccion instanceof RetirarEfectivo)
            transaccion.transaccionOk();
        else
            transaccion.transaccionNoOk();
    }
}
