package org.example;

public class SerieProgresiva implements Serie{
    protected int valorInicial;
    protected int valorActual;
    protected int paso;

    public SerieProgresiva(int paso) {
        this.paso = paso;
    }

    @Override
    public int siguiente() {
        int siguienteValor = valorActual;
        valorActual += paso;
        return siguienteValor;
    }

    @Override
    public void reiniciar() {
        valorActual = valorInicial;
    }

    @Override
    public void establecerValorInicial(int valorInicial) {
        this.valorInicial = valorInicial;
        this.valorActual = valorInicial;
    }
}
