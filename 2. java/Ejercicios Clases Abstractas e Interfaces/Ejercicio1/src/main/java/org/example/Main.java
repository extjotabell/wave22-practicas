package org.example;

public class Main {
    public static void main(String[] args){
        Ejecutivo eje = new Ejecutivo();
        Basic base = new Basic();
        Cobradores cobra = new Cobradores();

        eje.hacerDeposito();
        eje.transaccionNoOk("Deposito");
        eje.hacerTransferencia();
        eje.transaccionOk("Transferencia");

        System.out.println();

        base.hacerConsultaSaldo();
        base.transaccionOk("Consulta de Saldo");
        base.hacerRetiroEfectivo();
        base.transaccionNoOk("Retiro de Efectivo");

        System.out.println();

        cobra.hacerRetiroEfectivo();
        cobra.transaccionOk("Retiro de Efectivo");
        cobra.hacerConsultaSaldo();
        cobra.transaccionNoOk("Consulta de Saldo");

    }
}