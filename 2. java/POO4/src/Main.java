
public class Main {
    public static void main(String[] args) {
        Persona ejecutivo = new Ejecutivo();
        Persona basic = new Basic();
        Persona cobrador = new Cobrador();

        Transaccion deposito = new Deposito();
        Transaccion transferencia = new Transferencia();
        Transaccion consultaSaldo = new ConsultaSaldo();
        Transaccion retiroEfectivo = new RetiroEfectivo();
        Transaccion pagoServicios = new PagoServicios();

        ejecutivo.realizaAccion(deposito);
        basic.realizaAccion(consultaSaldo);
        cobrador.realizaAccion(retiroEfectivo);
        cobrador.realizaAccion(transferencia);


    }
}