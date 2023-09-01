package banco;

public class Cobrador extends Persona {


    @Override
    public void realizarTransaccion(Transaccion t) {
        if(t instanceof RetiroEfectivo || t instanceof ConsultaSaldo){
            t.transaccionOk();
        }else{
            t.transaccionNoOk();
        }
    }
}
