public class SerieNumerica extends Prototipo {

    private final Number tipoSerie;
    private Number valorInicial = 0;
    private Number valorSerie = 0;

    public SerieNumerica(Number tipoSerie) {
        this.tipoSerie = tipoSerie;
    }

    @Override
    public void valorSiguiente() {
        valorSerie = valorSerie.intValue() + valorInicial.intValue() + tipoSerie.intValue();
        System.out.println(valorSerie);
    }

    @Override
    public void reiniciarSerie() {
        valorSerie = 0;
        valorInicial = 0;
    }

    @Override
    public void establecerValorInicial(Number valorInicial) {
        this.valorInicial = valorInicial;
    }
}
