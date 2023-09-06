package org.example;

public class Basic implements ConsultaSaldo, PagoServicios, RetiroEfectivo{

    @Override
    public void hacerConsultaSaldo(){
        System.out.println("Procesando la operación -> Consulta de Saldo");
    }

    @Override
    public void hacerPagoServicios(){
        System.out.println("Procesando la operación -> Pago de Servicios");
    }

    @Override
    public void hacerRetiroEfectivo(){
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
