package entity;

import interfaces.IOperacion;

public class ClienteBasic extends EstadoOperacion implements IOperacion {

    @Override
    public void depositar() {
        transaccionNoOk();
    }

    @Override
    public void pagarServicio() {
        transaccionOk();
    }

    @Override
    public void retirarEfectivo() {
    transaccionOk();
    }

    @Override
    public void tranasferir() {
        transaccionNoOk();
    }

    @Override
    public void consultarSaldo() {
        transaccionOk();
    }

    @Override
    public String toString() {
        return "Cliente basic";
    }
}
