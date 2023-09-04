package main;

public class SerieDeTres extends Prototipo{
    public SerieDeTres() {
        super(0,3);
    }

    @Override
    public Number obtenerSiguiente() {
        actual = actual.intValue()+3;
        return actual;
    }

    @Override
    public void reiniciarSerie() {
        actual = 3;
    }

    @Override
    public void establecerInicial() {
        inicial = 1;
    }
}
