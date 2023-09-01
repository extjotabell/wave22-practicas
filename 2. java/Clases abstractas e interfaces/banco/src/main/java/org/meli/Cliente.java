package org.meli;

public abstract class Cliente {
    private String nombre;
    private String cvu;
    private int dni;
    private double Saldo;

    public abstract void realizarTransaccion(Transaccion transaccion);
}
