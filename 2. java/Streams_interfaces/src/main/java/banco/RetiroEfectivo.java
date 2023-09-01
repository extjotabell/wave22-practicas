package banco;

public class RetiroEfectivo implements Transaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Retirando efectivo");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Retiro no permitido");
    }
}
