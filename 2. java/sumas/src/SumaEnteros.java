public class SumaEnteros extends SumasNumerica<Integer> {

    public SumaEnteros(Integer valorInicial, Integer paso) {
        super(valorInicial, paso);
    }

    @Override
    protected Integer sumar(Integer a, Integer b) {
        return a + b;
    }
}
