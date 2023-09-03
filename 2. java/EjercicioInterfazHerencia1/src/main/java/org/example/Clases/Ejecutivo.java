package org.example.Clases;

import org.example.Interfaces.Deposito;
import org.example.Interfaces.Tranferencias;

public class Ejecutivo implements Deposito, Tranferencias {
    @Override
    public void RealizarDeposito() {
        System.out.println("Deposito realizado");
    }

    @Override
    public void HacerTransferencia() {
        System.out.println("Transeferencia realizada");
    }

    @Override
    public void TransaccionOk(String operacion) {
        System.out.println(operacion + "Realizado con exito");
    }

    @Override
    public void TransaccionNoOk(String operacion) {
        System.out.println(operacion+" Realizado con error");
    }
}
