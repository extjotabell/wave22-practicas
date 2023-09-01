public interface Transaccion {

    default void transaccionOk() {
        System.out.println("La transaccion salio bien");
    }

    default void transaccionNoOk() {
        System.out.println("La transaccion salio mal");
    }

}
