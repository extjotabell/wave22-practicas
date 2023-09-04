package org.example.Banco.Clases;

import org.example.Banco.Clases.Interfaces.Deposito;
import org.example.Banco.Clases.Interfaces.Tranferencias;

import java.util.Random;

public class Ejecutivo implements Deposito, Tranferencias {

    @Override
    public int RealizarDeposito() {
        Random random = new Random();
        int randomNum = random.nextInt(2);

        if (randomNum == 1){
            return 1;
        }
        else {
            return 0;
        }

    }
    @Override
    public void TransaccionOk(String operacion) {
        System.out.println(operacion + " Realizado con exito");
    }

    @Override
    public void TransaccionNoOk(String operacion) {
        System.out.println(operacion + " ERROR al realizar");
    }

    @Override
    public int HacerTransferencia() {
        Random random = new Random();
        int randomNum = random.nextInt(2);

        if (randomNum == 1){
            return 1;
        }
        else {
            return 0;
        }
    }
}
