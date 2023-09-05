public class SerieEnteros extends SerieNumerica<Integer> {

    private Integer incremental;
    private Integer valorInicial;
    private Integer valorActual;


    public SerieEnteros(Integer incremental) {
        this.incremental = incremental;
    }

    public Integer obtenerValorActual() {
        return valorActual;
    }

    @Override
    public Integer obtenerSiguiente() {
        Integer ultimo = obtenerValorActual() == null ? 0 : valorActual;
        valorActual = ultimo + incremental;
        return valorActual;
    }

    @Override
    public void reiniciarSerie() {
        valorActual = null;
    }

    @Override
    public void establecerValorInicial(Integer nuevoValorInicial) {
        valorInicial = nuevoValorInicial;
        valorActual = nuevoValorInicial;
    }


}
