public class SocorristaMoto extends Vehiculo{

    public void socorrer(Moto unaMoto){
        System.out.println("Socorriendo moto " + unaMoto.getPatente());
    }

    public SocorristaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente, double peso, int ruedas) {
        super(velocidad, aceleracion, anguloDeGiro, patente, peso, ruedas);
    }
}
