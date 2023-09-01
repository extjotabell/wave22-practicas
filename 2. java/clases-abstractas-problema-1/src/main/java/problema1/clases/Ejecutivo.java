package problema1.clases;

import problema1.interfaces.Deposito;
import problema1.interfaces.Transferencia;
public class Ejecutivo implements Deposito, Transferencia {

    @Override
    public void haciendoDeposito() {
        System.out.println("Ejecutivo haciendo deposito");
    }

    @Override
    public void hacerTransferencia() {
        System.out.println("Ejecutivo haciendo transferencia");
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
