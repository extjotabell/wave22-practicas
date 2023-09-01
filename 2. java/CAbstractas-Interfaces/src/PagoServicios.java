public class PagoServicios implements Transaction{
    @Override
    public void transaccionOk() {
        System.out.println("Realizándose el Pago de Servicios");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("No se pudo realizar el Pago de Servicios");
    }
}
