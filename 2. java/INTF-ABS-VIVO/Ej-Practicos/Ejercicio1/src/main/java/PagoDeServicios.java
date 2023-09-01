public interface PagoDeServicios extends Transaccion {

    default void pagarServicios() {
        System.out.println("Pagando servicios");
    }

}
