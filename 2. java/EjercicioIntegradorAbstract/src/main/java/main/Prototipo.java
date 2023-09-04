package main;

public abstract class Prototipo {

    protected int valorActual;

    public abstract void siguienteValor();

    public abstract void reiniciar();

    public abstract void valorInicial(int i);

    public int getValorActual() {
        return valorActual;
    }

    public void setValorActual(int valorActual) {
        this.valorActual = valorActual;
    }
}
