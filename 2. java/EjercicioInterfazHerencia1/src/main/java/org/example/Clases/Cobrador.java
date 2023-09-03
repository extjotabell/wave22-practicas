package org.example.Clases;

import org.example.Interfaces.ConsultaDeSaldo;
import org.example.Interfaces.RetiroDeEfectivo;

public class Cobrador implements RetiroDeEfectivo, ConsultaDeSaldo {
    @Override
    public void RealizarConsultaDeSaldo() {
        System.out.println("Consulta de saldo realizada");
    }

    @Override
    public void retiroDeEfecitvo() {
        System.out.println("Retiro de efectivo realizado");
    }

    @Override
    public void TransaccionOk(String operacion) {
        System.out.println(operacion + "Realizado con exito");
    }

    @Override
    public void TransaccionNoOk(String operacion) {
        System.out.println(operacion + "Realizado con error");
    }
}
