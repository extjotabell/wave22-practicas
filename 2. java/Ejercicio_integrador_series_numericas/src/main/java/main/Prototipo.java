package main;

public abstract class Prototipo <N extends Number>{

    protected N actual;
    protected N inicial;

    public Prototipo(N actual, N inicial) {
        this.actual = actual;
        this.inicial = inicial;
    }

    public abstract N obtenerSiguiente();

    public abstract void reiniciarSerie();

    public abstract void establecerInicial();
}
