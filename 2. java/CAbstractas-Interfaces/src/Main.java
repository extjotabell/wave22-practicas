// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Client ejecutivo    = new Ejecutivo();
        Client basic        = new Basic();
        Client cobrador     = new Cobrador();

        Transaction deposito = new Deposito();
        Transaction transferencia = new Transfer();
        Transaction consultaSaldo = new ConsultaSaldo();
        Transaction retiroEfectivo = new RetiroEfectivo();
        Transaction pagoServicios = new PagoServicios();

        ejecutivo.realizaAccion(deposito);
        ejecutivo.realizaAccion(pagoServicios);
        basic.realizaAccion(consultaSaldo);
        cobrador.realizaAccion(retiroEfectivo);
        cobrador.realizaAccion(transferencia);

    }
}