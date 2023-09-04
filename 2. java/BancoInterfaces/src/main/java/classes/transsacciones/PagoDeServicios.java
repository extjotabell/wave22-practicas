package classes.transsacciones;

import interfaces.Transaccion;

public class PagoDeServicios implements Transaccion {
    @Override
    public void transaccionOK() {

    }

    @Override
    public void transaccionNoOK() {

    }
    @Override
    public void realizarTransaccion() {
        System.out.println("Se realizó un Pago de servicios");
    }
}
