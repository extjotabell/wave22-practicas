package main;

public class SerieProgresiva extends Prototipo {

    private int valorInicial;

    public SerieProgresiva(int valorInicial) {
        this.valorInicial = valorInicial;
    }

    @Override
    public int siguienteValor() {
        int nextNumber = super.getValorActual() +valorInicial;
        this.valorActual = nextNumber;
        return nextNumber;
    }

    @Override
    public void reiniciar() {
        super.setValorActual(valorInicial);
    }

}
