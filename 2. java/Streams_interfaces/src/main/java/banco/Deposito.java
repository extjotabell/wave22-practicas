package banco;

public class Deposito implements Transaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Permitido");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Rechazado");
    }
}
