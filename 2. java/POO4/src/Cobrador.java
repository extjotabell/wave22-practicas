public class Cobrador extends Persona {
    @Override
    public void realizaAccion(Transaccion transaccion) {
        if (transaccion instanceof RetiroEfectivo || transaccion instanceof ConsultaSaldo){
            transaccion.transaccionOk();
        } else {
            transaccion.transaccionNoOk();
        }

    }
}
