package Clases;

import Interfaces.ConsultaSaldo;
import Interfaces.RetiroEfectivo;

public class Cobradores implements RetiroEfectivo, ConsultaSaldo {
    @Override
    public void consultaSaldo() {
        System.out.println("Consulta saldo...");
    }

    @Override
    public void retiroEfectivo() {
        System.out.println("Retiro Efectivo...");
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
