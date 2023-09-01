package series_numericas;

public class Prototipo {

    private double valorActual;
    private double valorInicial;

    private double valorPaso;

    double devolverSiguiente(){
        valorActual += valorPaso;
        return valorActual;
    }

    void reiniciarSerie(){
        valorActual = valorInicial;
    }

    void inicializar(double inicial){
        valorInicial = inicial;
        valorActual = inicial;
    }

    public Prototipo(double valorInicial, double valorPaso) {
        this.valorActual = valorInicial;
        this.valorInicial = valorInicial;
        this.valorPaso = valorPaso;
    }

    public double getValorActual() {
        return valorActual;
    }

    public void setValorActual(double valorActual) {
        this.valorActual = valorActual;
    }

    public double getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(double valorInicial) {
        this.valorInicial = valorInicial;
    }

    public double getValorPaso() {
        return valorPaso;
    }

    public void setValorPaso(double valorPaso) {
        this.valorPaso = valorPaso;
    }
}
