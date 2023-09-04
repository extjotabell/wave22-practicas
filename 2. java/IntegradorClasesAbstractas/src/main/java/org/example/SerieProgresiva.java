package org.example;

public class SerieProgresiva extends Prototipo{

    @Override
    public Number siguiente() {
        super.setValorActual(super.getValorActual().intValue()+super.getStep().intValue());
        return super.getValorActual();
    }

    @Override
    public void reiniciarSerie() {
        super.setValorActual(null);
    }

    @Override
    public void iniciarSerie(Number valorInicial) {
        super.setValorActual(valorInicial);
    }

    public SerieProgresiva(Number step) {
        super.setStep(step);
    }
}
