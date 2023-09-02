package entity;

import interfaces.IOperacion;

public class ClienteCobrador extends EstadoOperacion implements IOperacion {

    @Override
    public void depositar() {
        transaccionNoOk();
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
        transaccionNoOk();
    }

    @Override
    public void consultarSaldo() {
        transaccionOk();
    }

    @Override
    public String toString() {
        return "Cliente cobrador";
    }
}
