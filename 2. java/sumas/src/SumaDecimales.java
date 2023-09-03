public class SumaDecimales extends  SumasNumerica<Double> {
    public SumaDecimales(Double valorInicial, Double paso) {
        super(valorInicial, paso);
    }

    @Override
    protected Double sumar(Double a, Double b) {
        return a + b;
    }
}
