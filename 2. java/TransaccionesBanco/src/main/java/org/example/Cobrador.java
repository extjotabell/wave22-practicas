package org.example;

public class Cobrador {

    public void hacerTransaccion(Transaccion t){
        boolean transaccionViable = t.getClass().equals(ConsultaSaldo.class) || t.getClass().equals(RetiroEfectivo.class);

        if(!transaccionViable){
            t.transaccionNoOk();
            return;
        }
        
        t.transaccionOk();
    }
}
