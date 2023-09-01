package org.example;

public class Ejecutivo implements Deposito, Transferencia{

    @Override
    public void deposito(int cantidadADepositar) {
        System.out.println("Depositando: " + cantidadADepositar);
    }

    @Override
    public void Tranferencia(int cantidad) {
        System.out.println("Realizando transferencias: " + cantidad);

    }

    @Override
    public void transaccionOk() {

    }

    @Override
    public void transaccionNoOk() {

    }


}
