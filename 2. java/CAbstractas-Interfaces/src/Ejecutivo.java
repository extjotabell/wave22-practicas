public class Ejecutivo extends Client{


    @Override
    public void realizaAccion(Transaction transaction) {
        if (transaction instanceof Deposito || transaction instanceof Transfer ){
            transaction.transaccionOk();
        } else {
            transaction.transaccionNoOk();
        }
    }
}
