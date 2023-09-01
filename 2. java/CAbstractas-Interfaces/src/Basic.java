public class Basic extends Client{


    @Override
    public void realizaAccion(Transaction transaction) {
        if (transaction instanceof ConsultaSaldo || transaction instanceof PagoServicios || transaction instanceof RetiroEfectivo){
            transaction.transaccionOk();
        } else {
            transaction.transaccionNoOk();
        }
    }
}
