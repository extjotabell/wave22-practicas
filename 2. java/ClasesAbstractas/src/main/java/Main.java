public class Main {
    public static void main(String[] args) {
        Par par = new Par();
        Impar impar = new Impar();

        par.valorInicial(2);
        par.siguiente();
        par.siguiente();
        par.siguiente();
        par.reiniciar();
        par.siguiente();

        impar.valorInicial(0);
        impar.siguiente();
        impar.siguiente();
        impar.siguiente();
        impar.reiniciar();
        impar.siguiente();
    }
}
