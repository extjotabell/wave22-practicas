package org.example;

import java.util.Comparator;

public abstract class Prototipo<T extends Number> {

    private T valorInicial;
    private T valorActual;

    public abstract T siguienteValor();
    public abstract void reiniciarSerie();
    public abstract void establecerValorInicial(T valorInicial);

    public Prototipo(T valorInicial) {
        this.valorInicial = valorInicial;
    }

    public T getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(T valorInicial) {
        this.valorInicial = valorInicial;
    }

    public T getValorActual() {
        return valorActual;
    }

    public void setValorActual(T valorActual) {
        this.valorActual = valorActual;
    }
}
