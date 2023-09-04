package org.example.entity;

import org.example.interfaces.IOperacion;

public class ClienteEjecutivo extends Operacion implements IOperacion {

    @Override
    public void depositar() {
        transaccionOk();
    }

    @Override
    public void pagarServicio() {
        transaccionNoOk();
    }

    @Override
    public void retirarEfectivo() {
        transaccionOk();
    }

    @Override
    public void tranasferir() {
        transaccionOk();
    }

    @Override
    public void consultarSaldo() {
        transaccionNoOk();
    }

    @Override
    public String toString() {
        return "Cliente ejecutivo";
    }
}


