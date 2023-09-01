package problema1.clases;

import problema1.interfaces.Consulta_saldo;

public class Basic implements Consulta_saldo{
    @Override
    public void consultar_saldo() {
        System.out.println("Basic consultando saldo");
    }

    @Override
    public boolean transaccionOk() {
        return false;
    }

    @Override
    public boolean transaccionNoOk() {
        return false;
    }
}
