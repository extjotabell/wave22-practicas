package main;

public class SerieDe2 extends Prototipo {

    private int valorInicial;

    @Override
    public void siguienteValor() {
        this.setValorActual(super.getValorActual() +2);
        System.out.println("Valor actual: "+ this.valorActual);
    }

    @Override
    public void reiniciar() {
        super.setValorActual(this.valorInicial);
        System.out.println("Se ha reiniciado " + this.getClass().getSimpleName());
    }

    @Override
    public void valorInicial(int i) {
        this.valorInicial = i;
        super.setValorActual(i);
        System.out.println("Se ha inicializado " + this.getClass().getSimpleName() + "con el valor " + this.valorInicial);
    }
}
