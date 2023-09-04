package main;

public class Vehiculo {

    private int velocidad;
    private int aceleracion;
    private int anguloDeGiro;
    protected int peso;
    private String patente;
    protected int ruedas;

    public Vehiculo(int velocidad, int aceleracion, int anguloDeGiro, String patente) {
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        this.anguloDeGiro = anguloDeGiro;
        this.patente = patente;
    }

    public double calcularValorParaGanar() {
        return velocidad * (aceleracion * 0.5) / (anguloDeGiro*(peso-ruedas * 100));
    }

    public int getVelocidad() {
        return velocidad;
    }

    public int getAceleracion() {
        return aceleracion;
    }

    public int getAnguloDeGiro() {
        return anguloDeGiro;
    }

    public int getPeso() {
        return peso;
    }

    public String getPatente() {
        return patente;
    }

    public int getRuedas() {
        return ruedas;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "velocidad=" + velocidad +
                ", aceleracion=" + aceleracion +
                ", anguloDeGiro=" + anguloDeGiro +
                ", peso=" + peso +
                ", patente='" + patente + '\'' +
                ", ruedas=" + ruedas +
                '}';
    }
}
