package org.example;

public abstract class Prototipo {

    protected int contador;
    protected int valor;
    public abstract void NextTo();
    public abstract void reboot();
    public abstract void initialValue();

    public Prototipo(int contador, int valor) {
        this.contador = contador;
        this.valor = valor;
    }

}
