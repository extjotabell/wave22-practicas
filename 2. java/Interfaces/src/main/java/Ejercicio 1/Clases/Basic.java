package Clases;

import Interfaces.ConsultaSaldo;
import Interfaces.PagoServicios;
import Interfaces.RetiroEfectivo;

public class Basic implements ConsultaSaldo, PagoServicios, RetiroEfectivo {
    @Override
    public void consultaSaldo() {
        System.out.println("Consultando saldo..");
    }

    @Override
    public void pagoServicios() {
        System.out.println("Pagando servicio..");
    }

    @Override
    public void retiroEfectivo() {
        System.out.println("Retirando efectivo..");
    }

    @Override
    public void transaccionOk(String tipoTrans) {
        System.out.println(tipoTrans + "realizado.");
    }

    @Override
    public void transaccionNoOk(String tipoTrans) {
        System.out.println(tipoTrans + "no realizado.");
    }
}
