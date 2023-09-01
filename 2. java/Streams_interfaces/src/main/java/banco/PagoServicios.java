package banco;

public class PagoServicios implements Transaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Pagando servicios");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Pago no permitido");
    }
}
