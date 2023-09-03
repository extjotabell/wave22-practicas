public class Impar extends Prototipo{

    private int iniciar;
    private int contador = 3;
    @Override
    public void siguiente() {
        int total = this.iniciar + this.contador;
        this.contador = this.contador + 3;
        System.out.println(total);
    }

    @Override
    public void reiniciar() {
        this.contador = 3;
    }

    @Override
    public void valorInicial(int valor) {
        this.iniciar = valor;
    }
}
