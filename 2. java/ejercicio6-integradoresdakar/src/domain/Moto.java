package domain;

public class Moto extends Vehiculo {
    private Double peso;
    private int ruedas;
    public Moto(Double velocidad, Double aceleracion, int anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente);
        this.peso = 300.00;
        this.ruedas = 2;
    }
}
