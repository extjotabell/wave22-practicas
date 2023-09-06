package org.example;

public class Ejecutivo implements Deposito, Transferencia{

    @Override
    public void hacerDeposito(){
        System.out.println("Procesando la operación -> Depósito");
    }

    public void hacerTransferencia(){
        System.out.println("Procesando la operacion -> Transferencia");
    }

    @Override
    public void transaccionOk(String tipoTransaccion){
        System.out.println(tipoTransaccion + " realizada correctamente");
    }

    @Override
    public void transaccionNoOk(String tipoTransaccion){
        System.out.println(tipoTransaccion + " ha fallado");
    }
}
