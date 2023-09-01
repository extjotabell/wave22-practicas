public class RetiroEfectivo implements Transaction{
    @Override
    public void transaccionOk() {
        System.out.println("Realizándose retiro de efectivo.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("No se pudo retirar efectivo.");
    }
}
