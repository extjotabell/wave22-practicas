package Clases;

import Interfaces.Deposito;
import Interfaces.Transferencia;

public class Ejecutivos implements Deposito, Transferencia {
    private boolean saldo;

    public Ejecutivos(boolean saldo) {
        this.saldo = saldo;
    }

    @Override
    public void hacerDeposito() {
        System.out.println("Comenzando deposito...");
        if(this.saldo == true){
            transaccionOk("Deposito");
        }else{
            transaccionNoOk("Deposito");
        }
    }

    @Override
    public void transaccionOk(String tipoTrans) {
        System.out.println(tipoTrans + "realizado.");
    }

    @Override
    public void transaccionNoOk(String tipoTrans) {
        System.out.println(tipoTrans + "no realizado.");
    }

    @Override
    public void hacerTransferencia() {
        System.out.println("Comenzando transferencia...");
        if(this.saldo == true){
            transaccionOk("Transferencia");
        }else{
            transaccionNoOk("Transferencia");
        }
    }
}
