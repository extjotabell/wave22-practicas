public class SocorristaAuto extends Vehiculo{
    public void socorrer(Auto unAuto){
        System.out.println("Socorriendo auto " + unAuto.getPatente());
    }
    public SocorristaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente, double peso, int ruedas) {
        super(velocidad, aceleracion, anguloDeGiro, patente, peso, ruedas);
    }
}
