public class Cobrador extends Client{


    @Override
    public void realizaAccion(Transaction transaction) {
        if (transaction instanceof RetiroEfectivo || transaction instanceof ConsultaSaldo){
            transaction.transaccionOk();
        } else {
            transaction.transaccionNoOk();
        }
    }
}
