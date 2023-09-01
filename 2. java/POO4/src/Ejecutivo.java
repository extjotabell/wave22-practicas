public class Ejecutivo extends Persona{
    @Override
    public void realizaAccion(Transaccion transaccion) {
        if (transaccion instanceof PagoServicios || transaccion instanceof ConsultaSaldo || transaccion instanceof RetiroEfectivo){
            transaccion.transaccionOk();
        } else {
            transaccion.transaccionNoOk();
        }
    }
}
