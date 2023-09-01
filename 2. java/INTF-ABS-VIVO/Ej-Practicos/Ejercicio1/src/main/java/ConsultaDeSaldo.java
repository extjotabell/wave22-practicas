public interface ConsultaDeSaldo extends Transaccion {

    default void consultarSaldo() {
        System.out.println("Consultando saldo");
    }

}
