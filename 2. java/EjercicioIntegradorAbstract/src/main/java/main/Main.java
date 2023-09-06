package main;

public class Main {

    public static void main(String[] args) {
        SerieProgresiva sp = new SerieProgresiva(3);
        sp.siguienteValor();
        sp.siguienteValor();
        System.out.println(sp.getValorActual());
        sp.reiniciar();
        System.out.println(sp.getValorActual());
    }
}
