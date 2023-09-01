package banco;

public class Transferencia implements Transaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Realizando transferencia");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transferencia no permitida");
    }
}
