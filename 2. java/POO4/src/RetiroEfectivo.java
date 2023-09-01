public class RetiroEfectivo implements Transaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Realizándose retiro en efectivo.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Retiro en efectivo fallo.");
    }
}
