package models;

public abstract class Vehiculo {

    private String patente;
    private double velocidad;
    private double aceleracion;
    private double anguloDeGiro;
    private double peso;
    private int ruedas;

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }

    public double getAceleracion() {
        return aceleracion;
    }

    public void setAceleracion(double aceleracion) {
        this.aceleracion = aceleracion;
    }

    public double getAnguloDeGiro() {
        return anguloDeGiro;
    }

    public void setAnguloDeGiro(double anguloDeGiro) {
        this.anguloDeGiro = anguloDeGiro;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getRuedas() {
        return ruedas;
    }

    public void setRuedas(int ruedas) {
        this.ruedas = ruedas;
    }

    public Vehiculo(String patente, double velocidad, double aceleracion, double anguloDeGiro, double peso, int ruedas) {
        this.patente = patente;
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        this.anguloDeGiro = anguloDeGiro;
        this.peso = peso;
        this.ruedas = ruedas;
    }

    public Vehiculo() {
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "patente='" + patente + '\'' +
                ", velocidad=" + velocidad +
                ", aceleracion=" + aceleracion +
                ", anguloDeGiro=" + anguloDeGiro +
                ", peso=" + peso +
                ", ruedas=" + ruedas +
                '}';
    }
}
