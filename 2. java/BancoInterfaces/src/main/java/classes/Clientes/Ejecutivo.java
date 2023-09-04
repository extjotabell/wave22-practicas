package classes.Clientes;

import classes.transsacciones.Deposito;

public class Ejecutivo extends Cliente{
    public void realizarDeposito(){
        Deposito dep = new Deposito();
        dep.realizarTransaccion();
    }
}
