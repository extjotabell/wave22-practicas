public abstract class SumasNumerica<T> {
    private T valorInicial;
    private T valorActual;
    private T paso;

    public SumasNumerica(T valorInicial, T paso) {
        this.valorInicial = valorInicial;
        this.valorActual = valorInicial;
        this.paso = paso;
    }

    public T obtenerSiguienteValor() {
        valorActual = sumar(valorActual, paso);
        return valorActual;
    }

    public void reiniciarSerie() {
        valorActual = valorInicial;
    }

    public void establecerValorInicial(T valor) {
        valorInicial = valor;
        valorActual = valor;
    }

    public T getValorInicial() {
        return valorInicial;
    }

    public T getValorActual() {
        return valorActual;
    }

    protected abstract T sumar(T a, T b);

}