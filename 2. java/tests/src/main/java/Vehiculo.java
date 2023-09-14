public interface Vehiculo {
    public int velocidad = 100;

    void acelerar();
    default void frenar(){
        System.out.println("frenando");
    }
}
