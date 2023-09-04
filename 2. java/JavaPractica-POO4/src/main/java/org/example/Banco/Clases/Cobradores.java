package org.example.Banco.Clases;

import org.example.Banco.Clases.Interfaces.ConsultaDeSaldo;
import org.example.Banco.Clases.Interfaces.RetiroDeEfectivo;

import java.util.Random;

public class Cobradores implements ConsultaDeSaldo , RetiroDeEfectivo {

    @Override
    public int RealizarConsultaDeSaldo(){
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
    public int retiroDeEfecitvo(){
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


}
