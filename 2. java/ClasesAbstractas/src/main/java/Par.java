import java.util.ArrayList;
import java.util.List;

public class Par extends Prototipo{
    private int inicial;
    private int contador = 2;

    @Override
    public void siguiente() {
        int total = this.inicial + this.contador;
        this.contador = this.contador + 2;
        System.out.println(total);
    }

    @Override
    public void reiniciar() {
        this.contador = 2;
    }

    @Override
    public void valorInicial(int valor) {
        this.inicial = valor;
    }
}
