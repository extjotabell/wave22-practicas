package banco;

public class Main {
    public static void main(String[] args) {
        Transaccion pagoServicios = new PagoServicios();
        Cobrador cobrador = new Cobrador();
        cobrador.realizarTransaccion(pagoServicios);
    }
}
