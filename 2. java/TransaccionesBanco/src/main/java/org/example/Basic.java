package org.example;

public class Basic {
    public void hacerTransaccion(Transaccion t){
        boolean transaccionViable = t.getClass().equals(ConsultaSaldo.class) || t.getClass().equals(RetiroEfectivo.class) || t.getClass().equals(PagoServicio.class);

        if(!transaccionViable){
            t.transaccionNoOk();
            return;
        }

        t.transaccionOk();
    }
}
