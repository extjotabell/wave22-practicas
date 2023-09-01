package main;

public abstract class SerieProgresiva<T extends Number> {
    private T valorActual;

    public T getValorActual() {
        return valorActual;
    }

    public SerieProgresiva(T valorInicial) {
        this.valorActual = valorInicial;
    }

    public T valorSiguiente() {
        T siguiente = valorActual;
        calcularSiguiente(); // Llama al método abstracto para obtener el siguiente valor.
        return siguiente;
    }

    public void reiniciarSerie() {
        valorActual = getValorInicial();
        calcularSiguiente();
    }

    public void establecerValorInicial(T valorInicial) {
        valorActual = valorInicial;
    }

    protected void calcularSiguiente() {
    }

    protected abstract T getValorInicial();

    public abstract T calcularSiguienteValor();
}
