public class SocorristaMoto extends Socorrista<Motos> {
    @Override
    public void socorrer(Motos vehiculo) {
        System.out.println("Socorriento moto con patente: " + vehiculo.getPatente());
    }
}
