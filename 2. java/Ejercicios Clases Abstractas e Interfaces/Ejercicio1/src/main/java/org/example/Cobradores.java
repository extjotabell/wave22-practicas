package org.example;

public class Cobradores implements RetiroEfectivo, ConsultaSaldo{
    @Override
    public void hacerConsultaSaldo() {
        System.out.println("Procesando la operación -> Consulta de Saldo");
    }

    @Override
    public void hacerRetiroEfectivo() {
        System.out.println("Procesando la operación -> Retiro de Efectivo");
    }

    @Override
    public void transaccionOk(String tipoTransaccion) {
        System.out.println(tipoTransaccion + " realizada correctamente");
    }

    @Override
    public void transaccionNoOk(String tipoTransaccion) {
        System.out.println(tipoTransaccion + " ha fallado");
    }
}
