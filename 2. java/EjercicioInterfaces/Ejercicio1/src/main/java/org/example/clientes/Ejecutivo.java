package org.example.clientes;

import org.example.mediosTransaccion.Transaccion;
import org.example.mediosTransaccion.Deposito;
import org.example.mediosTransaccion.Transferencia;

public class Ejecutivo extends Cliente {
    @Override
    public void realizarTransaccion(Transaccion transaccion) {
        if(transaccion instanceof Deposito || transaccion instanceof Transferencia)
            transaccion.transaccionOk();
        else
            transaccion.transaccionNoOk();
    }
}
