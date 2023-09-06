package org.example;

public class Serie2<T extends Number> extends Prototipo{


    public Serie2(Number valorInicial) {
        super(valorInicial);
        setValorActual(2);
    }

    @Override
    public Number siguienteValor() {
        int valorNuevo = getValorActual().intValue() + 2;
        setValorActual(valorNuevo);
        return (T) Integer.valueOf(valorNuevo);
    }

    @Override
    public void reiniciarSerie() {
        setValorActual(getValorInicial());
    }

    @Override
    public void establecerValorInicial(Number valorInicial) {
        setValorInicial(valorInicial);
    }
}
