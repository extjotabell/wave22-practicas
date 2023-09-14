public interface Computadora {
    int nucleos = 2;

    static void explotar(){
        System.out.println("PC explotando");
    }

    public String arrancar(String prefix ,String suffix);

    default void hola(){
        System.out.println("hola");
    }

}
