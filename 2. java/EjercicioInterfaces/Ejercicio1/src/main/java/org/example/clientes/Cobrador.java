package org.example.clientes;

import org.example.mediosTransaccion.Transaccion;
import org.example.mediosTransaccion.ConsultaSaldo;
import org.example.mediosTransaccion.RetirarEfectivo;

public class Cobrador extends Cliente {
    @Override
    public void realizarTransaccion(Transaccion transaccion) {
        if(transaccion instanceof RetirarEfectivo || transaccion instanceof ConsultaSaldo)
            transaccion.transaccionOk();
        else
            transaccion.transaccionNoOk();
    }
}
