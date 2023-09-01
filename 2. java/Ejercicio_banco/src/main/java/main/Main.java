package main;

import main.cliente.Basico;
import main.cliente.Cliente;
import main.transacciones.*;

public class Main {
    public static void main(String[] args) {
        Cliente basico = new Basico("Juan","1111",1500);
        Transaccion tr = new ConsultaSaldo();

        System.out.println(basico.realizarTransaccion(new ConsultaSaldo()));
        System.out.println(basico.realizarTransaccion(new PagoServicios()));
        System.out.println(basico.realizarTransaccion(new Retiro()));
        System.out.println();
        System.out.println("-------TRANSACCION NO PERMITIDA PARA EL CLIENTE---------");
        System.out.println(basico.realizarTransaccion(new Transferencia()));

    }
}
