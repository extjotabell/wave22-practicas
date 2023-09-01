public interface Deposito extends Transaccion {

    default void depositar() {
        System.out.println("Depositando");
    }

}
