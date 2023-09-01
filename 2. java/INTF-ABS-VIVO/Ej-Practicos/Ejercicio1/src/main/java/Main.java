public class Main {
    public static void main(String[] args) {
        Basic clienteBasico = new Basic();
        Cobrador clienteCobrador = new Cobrador();
        Ejecutivo clienteEjecutivo = new Ejecutivo();

        clienteBasico.consultarSaldo();
        clienteCobrador.retirarEfectivo();
        clienteEjecutivo.depositar();
    }
}
