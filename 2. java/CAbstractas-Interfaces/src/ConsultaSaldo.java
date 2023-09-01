public class ConsultaSaldo implements Transaction{
    @Override
    public void transaccionOk() {
        System.out.println("Realizándose la Consulta de Saldo");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("No se pudo realizar la Consulta de Saldo");
    }
}
