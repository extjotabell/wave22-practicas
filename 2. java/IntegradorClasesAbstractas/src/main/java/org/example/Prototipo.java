package org.example;

public abstract class Prototipo <T extends Number>{
    private T valorActual;
    private T step;

    public abstract T siguiente();

    public abstract void reiniciarSerie();

    public abstract void iniciarSerie(T valorInicial);

    public T getValorActual() {
        return valorActual;
    }

    public T getStep() {
        return step;
    }

    public void setValorActual(T valorActual) {
        this.valorActual = valorActual;
    }

    public void setStep(T step) {
        this.step = step;
    }

}
