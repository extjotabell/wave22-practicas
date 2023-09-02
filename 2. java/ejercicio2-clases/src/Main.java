import entity.ClienteBasic;
import entity.ClienteCobrador;
import entity.ClienteEjecutivo;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        ClienteBasic clienteBasic = new ClienteBasic();
        ClienteCobrador clienteCobrador = new ClienteCobrador();
        ClienteEjecutivo clienteEjecutivo = new ClienteEjecutivo();

        clienteBasic.consultarSaldo();
        clienteBasic.depositar();

        clienteCobrador.pagarServicio();
        clienteCobrador.consultarSaldo();

        clienteEjecutivo.consultarSaldo();
        clienteEjecutivo.tranasferir();

    }
}