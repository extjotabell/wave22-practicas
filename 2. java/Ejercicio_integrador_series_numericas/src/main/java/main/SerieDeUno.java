package main;

public class SerieDeUno extends Prototipo<Number> {

    public SerieDeUno() {
        super(1,1);
    }

    @Override
    public Number obtenerSiguiente() {
        actual = actual.intValue()+2;
        return actual;
    }

    @Override
    public void reiniciarSerie() {
        actual = inicial;
    }

    @Override
    public void establecerInicial() {
        inicial = 1;
    }

}

