package banco;

public class Ejecutivo extends Persona {


    @Override
    public void realizarTransaccion(Transaccion t) {
        if(t instanceof Deposito || t instanceof Transferencia){
            t.transaccionOk();
        }else {
            t.transaccionNoOk();
        }
    }
}
