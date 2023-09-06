public class SocorristaAuto extends Socorrista<Autos> {

    @Override
    public void socorrer(Autos vehiculo) {
        System.out.println("Socorriento auto con patente: " + vehiculo.getPatente());
    }
}
