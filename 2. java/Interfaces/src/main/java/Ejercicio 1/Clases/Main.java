package Clases;

public class Main {
    public static void main(String[] args) {
        Clases.Ejecutivos ejecutivo = new Clases.Ejecutivos(true);
        ejecutivo.hacerDeposito();
        ejecutivo.hacerTransferencia();
        ejecutivo.transaccionNoOk("Deposito");
        ejecutivo.transaccionOk("Transferencia");
    }
}
