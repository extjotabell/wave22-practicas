package org.example;

public class Serie3<T extends Number> extends Prototipo{


    public Serie3(Number valorInicial) {
        super(valorInicial);
        setValorActual(3);
    }

    @Override
    public Number siguienteValor() {
        int valorNuevo = getValorActual().intValue() + 3;
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
