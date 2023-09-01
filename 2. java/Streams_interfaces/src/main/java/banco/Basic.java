package banco;

public class Basic extends Persona {


    @Override
    public void realizarTransaccion(Transaccion t) {
        if(t instanceof ConsultaSaldo || t instanceof PagoServicios || t instanceof RetiroEfectivo){
            t.transaccionOk();
        }else {
            t.transaccionNoOk();
        }
    }
}
