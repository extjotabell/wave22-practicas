public class Basic extends Persona{
    @Override
    public void realizaAccion(Transaccion transaccion) {
        if (transaccion instanceof Deposito || transaccion instanceof Transferencia){
            transaccion.transaccionOk();
        } else {
            transaccion.transaccionNoOk();
        }
    }
}
