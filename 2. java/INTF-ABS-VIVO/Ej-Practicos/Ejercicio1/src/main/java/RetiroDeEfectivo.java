public interface RetiroDeEfectivo extends Transaccion {

    default void retirarEfectivo() {
        System.out.println("Retirando efectivo");
    }

}
