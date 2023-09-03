package domain;

public abstract class Animal {
    public String emitirSonido() {
        return "El animal emite el sonido: ";
    }
    public abstract void comer();
}
