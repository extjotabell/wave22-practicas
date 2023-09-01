public class ConsultaSaldo implements Transaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Realizándose consula de saldo.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Consula de saldo fallo.");
    }
}
