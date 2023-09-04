package main;

public class SerieDeDos extends Prototipo{
    public SerieDeDos() {
        super(0,2);
    }

    @Override
    public Number obtenerSiguiente() {
        actual = actual.intValue()+2;
        return actual;
    }

    @Override
    public void reiniciarSerie() {
        actual = 2;
    }

    @Override
    public void establecerInicial() {
        inicial = 1;
    }
}
