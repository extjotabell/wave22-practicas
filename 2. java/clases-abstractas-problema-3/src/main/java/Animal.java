public abstract class Animal {
    String tipo;

    public Animal(String tipo) {
        this.tipo = tipo;
    }

    public abstract void emitirSonido();

    public String getTipo() {
        return tipo;
    }

}
