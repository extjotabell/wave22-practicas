package org.example;

public class Ejecutivo {
    public void hacerTransaccion(Transaccion t) {
        boolean transaccionViable = t.getClass().equals(Deposito.class) || t.getClass().equals(Transferencia.class);

        if (!transaccionViable) {
            t.transaccionNoOk();
            return;
        }

        t.transaccionOk();
    }
}
