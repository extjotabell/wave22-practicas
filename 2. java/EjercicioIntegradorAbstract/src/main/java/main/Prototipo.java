package main;

public abstract class Prototipo {

    protected int valorActual;

    public abstract int siguienteValor();

    public abstract void reiniciar();

    public int getValorActual() {
        return valorActual;
    }

    public void setValorActual(int valorActual) {
        this.valorActual = valorActual;
    }
}
