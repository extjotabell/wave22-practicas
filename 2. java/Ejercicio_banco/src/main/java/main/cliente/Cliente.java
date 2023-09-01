package main.cliente;

import main.transacciones.Transaccion;

public abstract class Cliente {
    protected final String nombre;

    private final String cuenta;

    private final double saldo;

    public Cliente(String nombre, String cuenta, double saldo) {
        this.nombre = nombre;
        this.cuenta = cuenta;
        this.saldo = saldo;
    }

    public abstract String realizarTransaccion(Transaccion tr);
}
