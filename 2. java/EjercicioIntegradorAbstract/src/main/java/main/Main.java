package main;

public class Main {

    public static void main(String[] args) {
        SerieDe2 serie2 = new SerieDe2();
        serie2.valorInicial(5);
        serie2.siguienteValor();
        serie2.siguienteValor();
        serie2.siguienteValor();
        serie2.reiniciar();
        SerieDe4 serie4 = new SerieDe4();
        serie4.valorInicial(10);
        serie4.siguienteValor();
        serie4.siguienteValor();
        serie4.reiniciar();
        serie4.siguienteValor();
    }
}
