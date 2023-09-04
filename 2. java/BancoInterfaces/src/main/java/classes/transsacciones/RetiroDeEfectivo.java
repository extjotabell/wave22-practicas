package classes.transsacciones;

import interfaces.Transaccion;

public class RetiroDeEfectivo implements Transaccion {
    @Override
    public void transaccionOK() {

    }

    @Override
    public void transaccionNoOK() {

    }
    @Override
    public void realizarTransaccion() {
        System.out.println("Se realizó un Retiro de efectivo");
    }
}
