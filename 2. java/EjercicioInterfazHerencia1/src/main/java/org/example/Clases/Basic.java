package org.example.Clases;
import org.example.Interfaces.*;

public class Basic implements ConsultaDeSaldo, PagoServicio, RetiroDeEfectivo {
    @Override
    public void TransaccionOk(String operacion) {
        System.out.println(operacion + "Realizado con exito");
    }
    @Override
    public void TransaccionNoOk(String operacion) {
        System.out.println(operacion+" Realizado con error");
    }

    @Override
    public void RealizarConsultaDeSaldo() {
        System.out.println("Consulta de saldo realizada");
    }

    @Override
    public void PagarServicio() {
        System.out.println("Pago realizado");
    }

    @Override
    public void retiroDeEfecitvo() {
        System.out.println("Retiro de efectivo realizado");
    }
}