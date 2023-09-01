package problema1.clases;

import problema1.interfaces.Consulta_saldo;

public class Cobrador implements Consulta_saldo{
    @Override
    public void consultar_saldo() {
        System.out.println("Cobrador consultando saldo");
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