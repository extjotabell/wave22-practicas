public class Deposito implements Transaction{
    @Override
    public void transaccionOk() {
        System.out.println("Realizándose depósito");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("No se pudo realizar el depósito");
    }
}
